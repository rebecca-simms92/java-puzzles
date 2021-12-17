package com.simms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {

    RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    public void zeroReturnsEmptyString() {
        assertEquals("0 is an empty string", "", romanNumerals.convertToRomanNumeral(0));
    }

    @Test
    public void oneIsReturnedAsI() {
        assertEquals("1 is 'I'", "I", romanNumerals.convertToRomanNumeral(1));
    }

    @Test
    public void twoIsReturnedAsII() {
        assertEquals("2 is II", "II", romanNumerals.convertToRomanNumeral(2));
    }

    @Test
    public void fourIsReturnedAsIV() {
        assertEquals("4 is IV", "IV", romanNumerals.convertToRomanNumeral(4));
    }

    @Test
    public void fiveIsReturnedAsV() {
        assertEquals("5 is V", "V", romanNumerals.convertToRomanNumeral(5));
    }

    @Test
    public void sixIsReturnedAsVI() {
        assertEquals("6 is VI", "VI", romanNumerals.convertToRomanNumeral(6));
    }

    @Test
    public void nineIsReturnedAsIX() {
        assertEquals("9 is IX", "IX", romanNumerals.convertToRomanNumeral(9));
    }

    @Test
    public void tenIsReturnedAsX() {
        assertEquals("10 is X", "X", romanNumerals.convertToRomanNumeral(10));
    }




}
