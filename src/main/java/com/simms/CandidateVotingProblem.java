package com.simms;

import java.util.*;

public class CandidateVotingProblem {

    Map<String, Integer> candidates = new HashMap();


    public String getTopK(int num) {
        if (candidates.isEmpty()) {
            return "Top " + num + " candidates are: []";
        }
        LinkedHashMap<String, Integer> sortedCandidates = new LinkedHashMap<>();
        candidates.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedCandidates.put(x.getKey(), x.getValue()));

        List<String> cand = new ArrayList<>();
        while (cand.size() < num) {
            int topVotes = sortedCandidates.entrySet().iterator().next().getValue();
            sortedCandidates.forEach((name, votes) -> {
                if (votes == topVotes && !cand.contains(name)) {
                    cand.add(name);
                }
            });
        }
//            List<String> cand = new ArrayList<>();
//            Integer mostVotes = sortedCandidates.entrySet().iterator().next().getValue();
//            sortedCandidates.forEach((name, votes) -> {
//                if (votes == mostVotes) {
//                    cand.add(name);
//                }
//            });
        return "Top " + num + " candidates are: " + cand;
    }

    public void vote(String name) {
        if (candidates.containsKey(name)) {
            int votes = candidates.get(name);
            candidates.put(name, votes + 1);
        } else {
            candidates.put(name, 1);
        }
    }
}

