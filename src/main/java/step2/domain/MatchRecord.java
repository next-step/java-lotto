package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.domain.MatchFactory.*;

public class MatchRecord {

    private final Map<Match, Integer> numberOfMatches;

    private MatchRecord(Map<Match, Integer> numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static MatchRecord createRecord() {
        Map<Match, Integer> numberOfMatches = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            numberOfMatches.put(match(i, false), 0);
        }

        numberOfMatches.put(match(5, true), 0);

        return new MatchRecord(numberOfMatches);
    }

    public Map<Match, Integer> countNumber(List<List<Integer>> purchaseNumbers, Number number) {
        for (List<Integer> purchaseNumber : purchaseNumbers) {
            int count = countWithPurchaseNumber(purchaseNumber, number.winningNumbers());
            boolean isBonus = isContainBonusNumber(count, purchaseNumber, number.bonusNumber());
            Match match = match(count, isBonus);

            Integer value = numberOfMatches.get(match);
            numberOfMatches.put(match, ++value);
        }

        return numberOfMatches;
    }

    private int countWithPurchaseNumber(List<Integer> number, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            count = count(number, count, winningNumber);
        }

        return count;
    }

    private int count(List<Integer> number, int count, Integer winningNumber) {
        if (number.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private boolean isContainBonusNumber(int count, List<Integer> number, int bonusNumber) {
        if (count != 5) {
            return false;
        }

        return number.contains(bonusNumber);
    }
}
