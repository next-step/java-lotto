package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRecord {

    private final Map<Match, Integer> numberOfMatches;

    private MatchRecord(Map<Match, Integer> numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static MatchRecord createRecord() {
        Map<Match, Integer> numberOfMatches = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            numberOfMatches.put(new Match(i, false), 0);
        }

        numberOfMatches.put(new Match(5, true), 0);

        return new MatchRecord(numberOfMatches);
    }

    public Map<Match, Integer> countNumber(List<List<Integer>> purchaseNumbers, Number number) {
        for (List<Integer> purchaseNumber : purchaseNumbers) {
            int count = count(purchaseNumber, number.winningNumbers());
            boolean isBonus = isBonus(count, purchaseNumber, number.bonusNumber());
            Match match = new Match(count, isBonus);
            Integer value = numberOfMatches.get(match);
            numberOfMatches.put(match, ++value);
        }

        return numberOfMatches;
    }

    private boolean isBonus(int count, List<Integer> number, int bonusNumber) {
        if (count != 5) {
            return false;
        }

        return number.contains(bonusNumber);
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
