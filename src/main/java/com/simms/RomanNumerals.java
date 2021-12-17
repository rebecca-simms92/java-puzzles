package com.simms;

//Task: For a single number input, convert to a Roman Numeral String output.

public class RomanNumerals {

    public String convertToRomanNumeral(int num) {
        StringBuilder romanNumeral = new StringBuilder();

        String[] numerals = {"X", "IX", "V", "IV", "I"};
        int[] numbers = {10, 9, 5, 4, 1};

        for (int i=0; i<numbers.length; i++) {
            while (num >= numbers[i]) {
                romanNumeral.append(numerals[i]);
                num -= numbers[i];
            }
        }
        return romanNumeral.toString();
    }

}
