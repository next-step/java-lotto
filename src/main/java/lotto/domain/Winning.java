package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Winning {

    Map<MatchNumber, Count> winning = new LinkedHashMap<>();

    public Winning() {
        winning.put(new MatchNumber(3), new Count(0));
        winning.put(new MatchNumber(4), new Count(0));
        winning.put(new MatchNumber(5), new Count(0));
        winning.put(new MatchNumber(6), new Count(0));
    }

    public Map<MatchNumber, Count> getWinning() {
        return winning;
    }

    public void record(int matchNumbers) {
        winning.keySet().forEach(matchNumber -> updateCount(matchNumber, matchNumbers));
    }

    public void updateCount(MatchNumber matchNumber, int matchNumbers) {
        if (matchNumber.getMatchNumber() == matchNumbers) {
            winning.get(matchNumber)
                    .update();
        }
    }

    public int getSumAmount() {
        return winning.keySet()
                .stream()
                .mapToInt(this::multiply)
                .sum();
    }

    private int multiply(MatchNumber matchNumber) {
        return Amount.getWinningMoney(matchNumber.getMatchNumber()) * winning.get(matchNumber).getCount();
    }
}
