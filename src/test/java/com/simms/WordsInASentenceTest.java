package com.simms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsInASentenceTest {

    WordsInASentence wordsInASentence = new WordsInASentence();

    @Test
    public void emptyStringReturnsZeroMaxWords() {
        assertEquals("An empty string has zero words", 0, wordsInASentence.findMaximumNumberOfWords(" "));
    }

    @Test
    public void stringWithOneSentenceMaxWordsIsNumberOfWordsInSentence() {
        assertEquals("Max words 'test.' is 1", 1, wordsInASentence.findMaximumNumberOfWords("test."));
    }

    @Test
    public void stringWithNoPunctionationGivesZeroMaxWords() {
        assertEquals("Max words in 'one two three' is 0", 0, wordsInASentence.findMaximumNumberOfWords("one two three"));
    }

    @Test
    public void stringWithOneSentenceMultiplePunctuationMaxWordsIsNumberOfWordsInSentence() {
        assertEquals("Max words in 'test.?!' is 1", 1, wordsInASentence.findMaximumNumberOfWords("test.?!"));
    }

    @Test
    public void stringWithMultipleSentencesMaxWordsIsInLongestSentence() {
        assertEquals("Max words in 'test. one two. three four five? three!", 3, wordsInASentence.findMaximumNumberOfWords("test. one two. three four five? three!"));
    }
}
