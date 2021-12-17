package com.simms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

public class CandidateVotingProblemTest {

    private CandidateVotingProblem candidateVotingProblem;

    @Before
    public void setUp() {
        candidateVotingProblem = new CandidateVotingProblem();
    }

    @Test
    public void votingForNobodyReturnsZeroTopCandidates() {
        assertEquals("Zero votes means there are zero top candidates", generateOutput(5, ""), candidateVotingProblem.getTopK(5));
    }

    @Test
    public void votingForOneCandidateAlwaysReturnsThatCandiateForTheTopOneCandidate() {
        candidateVotingProblem.vote("Bob");
        assertEquals("Only voting for one person means there is only one top candidate", generateOutput(1, "Bob"), candidateVotingProblem.getTopK(1));
    }

    @Test
    public void votingForOneCandidateAlwaysReturnsThatCandidateForAnyNumberOfTopCandidates() {
        candidateVotingProblem.vote("Bob");
        assertEquals("Only voting for one person means there is only one top candidate", generateOutput(3, "Bob"), candidateVotingProblem.getTopK(3));
    }

    @Test
    public void votingMultipleTimesForOnePersonReturnsThatCandidateAsTopCandidate() {
        candidateVotingProblem.vote("Steve");
        candidateVotingProblem.vote("Steve");
        assertEquals("Voting for Steve twice, returns Steve as top candidate", generateOutput(2, "Steve"), candidateVotingProblem.getTopK(2));
    }

    @Test
    public void votingForTwoCandidatesReturnsThemBothAsTopTwoCandidates() {
        candidateVotingProblem.vote("Bob");
        candidateVotingProblem.vote("Steve");
        assertEquals("Voting for Bob and Steve returns them both as top 1 candidates", generateOutput(1, "Bob, Steve"), candidateVotingProblem.getTopK(1));
    }

    @Test
    public void votingForTwoCandidatesReturnsOnlyTopCandidate() {
        candidateVotingProblem.vote("Bob");
        candidateVotingProblem.vote("Steve");
        candidateVotingProblem.vote("Bob");
        assertEquals("Voting for Bob more than Steve returns Bob as top 1 candidates", generateOutput(1, "Bob"), candidateVotingProblem.getTopK(1));
    }

    @Test
    public void votingForSeveralCandidatesReturnsTop2Candidate() {
        candidateVotingProblem.vote("Bob");
        candidateVotingProblem.vote("Steve");
        candidateVotingProblem.vote("Bob");
        candidateVotingProblem.vote("Bob");
        candidateVotingProblem.vote("Dave");
        candidateVotingProblem.vote("Dave");
        assertEquals("Voting for multiple candidates returns top 2 candidates", generateOutput(2, "Bob, Dave"), candidateVotingProblem.getTopK(2));
    }



    private String generateOutput(int number, String name) {
        return "Top " + number + " candidates are: [" + name + "]";
    }


}