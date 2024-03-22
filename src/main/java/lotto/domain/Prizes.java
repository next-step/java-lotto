package lotto.domain;

import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Integer> calculateMatchCounts(List<Integer> matchCounts) {
        for (Prize prize : prizes) {
            int matchCount = prize.getMatchCount();
            int initial = matchCount - Prize.FOURTH_PRIZE.getMatchCount();
            if (prize.containsPrize()) {
                matchCounts.set(initial, matchCounts.get(initial) + 1);
            }
        }
        return matchCounts;
    }

}
