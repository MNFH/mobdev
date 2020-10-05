package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button reset;
    private TextInputEditText time;
    private TextView finalResult;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (TextInputEditText) findViewById(R.id.textInputEditText);
        button = (Button) findViewById(R.id.button2);
        reset = (Button) findViewById(R.id.button);
        finalResult = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = true;
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();
                runner.execute(sleepTime);
            }
        });
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isRunning = false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Exit Confirmation");
        ab.setMessage("are you sure to exit?");
        ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //if you want to kill app . from other then your main avtivity.(Launcher)
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        ab.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ab.show();
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;

        @Override
        protected String doInBackground(String... params) {
            try {
                Integer time = Integer.parseInt(params[0]);
                while (time > 0 && isRunning){
                    publishProgress(String.valueOf(time));
                    Thread.sleep(1000);
                    time -= 1;
                }
                if(!isRunning) {
                    resp = params[0];
                }
                else{
                    resp = "0";
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
//            progressDialog.dismiss();
            finalResult.setText(result);
            button.setEnabled(true);
        }

        @Override
        protected void onPreExecute() {
            button.setEnabled(false);
        }

        @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);
            // Things to be done while execution of long running operation is in
            // progress. For example updating ProgessDialog
        }
    }

}