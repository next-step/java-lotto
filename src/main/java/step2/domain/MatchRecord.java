package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRecord {

    private final Map<Integer, Integer> numberOfMatches;

    private MatchRecord(Map<Integer, Integer> numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static MatchRecord createRecord() {
        Map<Integer, Integer> numberOfMatches = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            numberOfMatches.put(i, 0);
        }

        return new MatchRecord(numberOfMatches);
    }

    public Map<Integer, Integer> countNumber(List<List<Integer>> numbers, List<Integer> winningNumbers) {
        for (List<Integer> number : numbers) {
            int count = count(number, winningNumbers);
            Integer value = numberOfMatches.get(count);
            numberOfMatches.put(count, ++value);
        }

        return numberOfMatches;
    }

    private int count(List<Integer> number, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            count = matchNumber(number, count, winningNumber);
        }

        return count;
    }

    private int matchNumber(List<Integer> number, int count, Integer winningNumber) {
        if (number.contains(winningNumber)) {
            count++;
        }
        return count;
    }
}
