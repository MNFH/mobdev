package com.example.tutorial2;

public class ConvertTemperature {
    public double convertCelciusToFarenheit(double temperature){
        double result = (temperature*9/5)+32;
        return result;
    }
    public double convertFarenheitToCelcius(double temperature){
        double result = (temperature-32)*5/9;
        return result;
    }
    public double convertKelvinToFarenheit(double temperature){
        double result = (temperature-273.15)*9/5 + 32;
        return result;
    }
    public double convertCelciusToKelvin(double temperature){
        double result = temperature + 273.15;
        return result;
    }
    public double convertFarenheitToKelvin(double temperature){
        double result = (temperature-32)*5/9 + 273.15;
        return result;
    }
    public double convertKelvinToCelcius(double temperature){
        double result = temperature - 273.15;
        return result;
    }
}
