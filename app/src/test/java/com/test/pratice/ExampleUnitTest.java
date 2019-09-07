package com.test.pratice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void a() {
        test();
    }
    public void test(String...values){
        test2(values);
    }

    public void test2(String[]values){
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}