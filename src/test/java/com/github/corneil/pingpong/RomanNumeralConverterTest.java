package com.github.corneil.pingpong;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Corneil on 2016-07-21.
 */
public class RomanNumeralConverterTest {
    @Test
    public void testConvert1() {
        assertEquals("I", RomanNumeralConvert.convert(1));
    }

    @Test
    public void testConvert2() {
        assertEquals("II", RomanNumeralConvert.convert(2));
    }

    @Test
    public void testConvert3() {
        assertEquals("III", RomanNumeralConvert.convert(3));
    }

    @Test
    public void testConvert4() {
        assertEquals("IV", RomanNumeralConvert.convert(4));
    }

    @Test
    public void testConvert5() {
        assertEquals("V", RomanNumeralConvert.convert(5));
    }

    @Test
    public void testConvert9() {
        assertEquals("IX", RomanNumeralConvert.convert(9));
    }

    @Test
    public void testConvert10() {
        assertEquals("X", RomanNumeralConvert.convert(10));
    }

    @Test
    public void testConvert50() {
        assertEquals("L", RomanNumeralConvert.convert(50));
    }

    @Test
    public void testConvert40() {
        assertEquals("XL", RomanNumeralConvert.convert(40));
        assertEquals("XLI", RomanNumeralConvert.convert(41));
        assertEquals("XXXIX", RomanNumeralConvert.convert(39));
    }

    @Test
    public void testConvert90() {
        assertEquals("LXXXIX", RomanNumeralConvert.convert(89));
        assertEquals("XC", RomanNumeralConvert.convert(90));
        assertEquals("XCI", RomanNumeralConvert.convert(91));
    }

    @Test
    public void testParse1() {
        assertEquals(1, RomanNumeralConvert.parse("I"));
    }

    @Test
    public void testParse4() {
        assertEquals(4, RomanNumeralConvert.parse("IV"));
    }

    @Test
    public void testParse9() {
        assertEquals(9, RomanNumeralConvert.parse("IX"));
    }

    @Test
    public void testParse10() {
        assertEquals(10, RomanNumeralConvert.parse("X"));
    }

    @Test
    public void testParse5326() {
        assertEquals(5623, RomanNumeralConvert.parse("MMMMMDCXXIII"));
    }

    @Test
    public void testParse1965() {
        assertEquals(1965, RomanNumeralConvert.parse("MCMLXV"));
    }

    @Test
    public void testWide() {
        Random rand = new Random();
        for (int i = 1; i <= 500; i++) {
            int number = rand.nextInt(10000) + 1;
            String numerals = RomanNumeralConvert.convert(number);
            int arabic = RomanNumeralConvert.parse(numerals);
            assertEquals("Problem converting:" + number + ":" + numerals, number, arabic);
        }
    }

    @Test
    public void testThousands() {
        for (int i = 1000; i <= 10000; i += 500) {
            String numerals = RomanNumeralConvert.convert(i);
            int arabic = RomanNumeralConvert.parse(numerals);
            assertEquals("Problem converting:" + i + ":" + numerals, i, arabic);
            System.out.println(Integer.toString(i) + " = " + numerals);
        }
    }
}
