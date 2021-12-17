package com.simms;

//Given a string S return the maximum number of words in a sentence.
//The text can be divided into sentences by:
//1. Splitting it at dots
//2. Or splitting it at question mark
//3. Or splitting it at exclamation mark
//E.g. Given S="we test coders. give us a try?" function should return 4.

public class WordsInASentence {

    public int findMaximumNumberOfWords(String s) {

        if (stringDoesntHaveASentence(s)) {
            return 0;
        }

        String[] sentences = s.split("[.?!]");

        int maxWords = 0;

        for (String sentence : sentences) {
            String trimmedSentence = sentence.trim();
            int numOfWords = numberOfSpacesInASentence(trimmedSentence) + 1;
            if (numOfWords > maxWords) {
                maxWords = numOfWords;
            }
        }
        return maxWords;
    }

    private int numberOfSpacesInASentence(String sentence) {
        return sentence.length() - sentence.replaceAll(" ", "").length();
    }

    private boolean stringDoesntHaveASentence(String s) {
        return !s.contains(".") && !s.contains("!") && !s.contains("?");
    }
}
