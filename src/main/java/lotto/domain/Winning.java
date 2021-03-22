package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Winning {

    Map<Rank, Count> winning = new LinkedHashMap<>();

    public Winning() {
        winning.put(Rank.FIFTH, new Count(0));
        winning.put(Rank.FOURTH, new Count(0));
        winning.put(Rank.THIRD, new Count(0));
        winning.put(Rank.SECOND, new Count(0));
        winning.put(Rank.FIRST, new Count(0));
    }

    public Map<Rank, Count> getWinning() {
        return winning;
    }

    public void record(int countMatchNumber, boolean bonusBall) {
        if (Rank.rank(countMatchNumber, bonusBall) != Rank.MISS) {
            winning.get(Rank.rank(countMatchNumber, bonusBall)).update();
        }
    }

    public int getSumAmount() {
        int sum = 0;
        for (Rank rank : winning.keySet()) {
            int multiply = rank.getPrice() * winning.get(rank).getCount();
            sum += multiply;
        }

        return sum;
    }
}
