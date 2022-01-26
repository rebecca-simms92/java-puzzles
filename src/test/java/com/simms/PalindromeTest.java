package com.simms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    private static final Palindrome palindrome = new Palindrome();

    @Test
    public void singleNumberIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome(0));
        assertEquals(true, palindrome.isPalindrome(1));
    }

    @Test
    public void numberTwoDigitNumber() {
        assertEquals(false, palindrome.isPalindrome(12));
        assertEquals(true, palindrome.isPalindrome(11));
    }

    @Test
    public void checkOddDigitNumber() {
        assertEquals(true, palindrome.isPalindrome(121));
        assertEquals(true, palindrome.isPalindrome(123454321));
        assertEquals(false, palindrome.isPalindrome(1234312));
    }

    @Test
    public void checkEvenDigitNumber() {
        assertEquals(true, palindrome.isPalindrome(12344321));
        assertEquals(false, palindrome.isPalindrome(1223443111));

    }


}
