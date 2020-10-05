package com.example.tutorial2;

import org.junit.Test;
import static com.example.tutorial2.ConvertName.changeName;
import static org.junit.Assert.*;
public class MainActivityUnitTest {
    @Test
    public void testChangeName(){
        String name = "hehehe";
        String actual = changeName(name);
        String expected = "Hello hehehe!";
        assertEquals(actual,expected);
    }
}
