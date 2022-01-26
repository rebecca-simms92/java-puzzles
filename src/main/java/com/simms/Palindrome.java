package com.simms;

public class Palindrome {

    public boolean isPalindrome(int number) {
        String originalNumber = Integer.toString(number);
        String reversedNumber = new StringBuilder(originalNumber).reverse().toString();

        return originalNumber.equals(reversedNumber);
    }
}
