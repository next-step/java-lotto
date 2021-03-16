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
        for (MatchNumber matchNumber : winning.keySet()) {
            if (matchNumber.getMatchNumber() == matchNumbers) {
                winning.get(matchNumber)
                        .update();
            }
        }
    }

    public int getSumAmount() {
        int sum = 0;

        for (MatchNumber matchNumber : winning.keySet()) {
            sum += Amount.getWinningMoney(matchNumber.getMatchNumber()) *
                                            winning.get(matchNumber)
                                                    .getCount();
        }

        return sum;
    }
}
