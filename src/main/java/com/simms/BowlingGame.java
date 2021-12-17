package com.simms;

public class BowlingGame {

    private int score = 0;
    private final int[] rolls = new int[21];
    private int rollNumber = 0;


    public void roll(int pins) {
        rolls[rollNumber] = pins;
        if (isStrike(pins) && !isLastFrame(rollNumber)) {
            rollNumber++;
        }
        rollNumber++;
    }

    private boolean isLastFrame(int rollNumber) {
        return rollNumber >= 18;
    }

    private boolean isStrike(int pins) {
        return pins == 10;
    }


    public int score() {
        for (int i=0; i<rolls.length-1; i++) {
            score += rolls[i];
        }

        for (int i=0; i<rolls.length-1; i+=2) {
            checkForSpare(i);
            checkForStrike(i);
        }

        return score;
    }

    private void checkForStrike(int i) {
        if (isStrike(rolls[i])) {
            score += rolls[i+2];
            if (!isLastFrame(i)) {
                if (isStrike(rolls[i+2])) {
                    score += rolls[i+4];
                } else {
                    score += rolls[i+3];
                }
            }
        }
    }

    private void checkForSpare(int i) {
        if (!isStrike(rolls[i]) & isStrike(rolls[i] + rolls[i+1])) {
            score += rolls[i+2];
        }
    }
}
