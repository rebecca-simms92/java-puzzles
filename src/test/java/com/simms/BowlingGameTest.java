package com.simms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    private void identicalRolls(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            bowlingGame.roll(pins);
        }
    }

    @Test
    public void rollingAllGutterBallsGivesZeroScore() {
        identicalRolls(20, 0);
        assertEquals("Gutter game gives zero score.", bowlingGame.score(), 0);
    }

    @Test
    public void rollingAllOnesGivesAScoreOf20() {
        identicalRolls(20, 1);
        assertEquals("Rolling all ones gives a score of 20.", bowlingGame.score(), 20);
    }

    @Test
    public void testRollingASpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        identicalRolls(18, 1);

        assertEquals("Rolling a spare add the next roll to the score.", bowlingGame.score(), 29);
    }

    @Test
    public void testRollingASpare2() {
        identicalRolls(10,1);
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(9);
        identicalRolls(7,0);

        assertEquals("Rolling a spare in the middle of a game.", bowlingGame.score(), 38);
    }

    @Test
    public void testRollingASpareWithTheLastBall() {
        identicalRolls(18,0);
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(9);

        assertEquals("Rolling a spare with the last balls add the next ball to the score.", bowlingGame.score(), 19);
    }

    @Test
    public void testRollingAStrike() {
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(2);
        identicalRolls(16,0);

        assertEquals("Rolling a strike adds the next two rolls onto score.", bowlingGame.score(), 16);
    }

    @Test
    public void testRollingAStrikeInTheLastFrame() {
        identicalRolls(18,0);
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(1);

        assertEquals("Rolling a strike in the last frame adds the next two rolls to score.", bowlingGame.score(), 14);
    }

    @Test
    public void testRollingASpareAndStrikeInTheSameGame() {
        bowlingGame.roll(1);
        identicalRolls(2,4);
        bowlingGame.roll(5);
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        identicalRolls(2,5);
        bowlingGame.roll(10);
        bowlingGame.roll(0);
        bowlingGame.roll(1);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(10);
        bowlingGame.roll(2);
        bowlingGame.roll(8);
        bowlingGame.roll(6);

        assertEquals("Test game with spares and strikes", bowlingGame.score(), 133);
    }



    @Test
    public void checkPerfectGame() {
        identicalRolls(12,10);
        assertEquals("Check perfect game score 300", bowlingGame.score(), 300);
    }

}
