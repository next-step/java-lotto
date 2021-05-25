package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Prizes {
    private final Map<Integer, Integer> prizes;

    public Prizes(List<Reward> rewards) {
        this.prizes = Award.makePrizes(rewards);
    }

    public Map<Integer, Integer> getPrizes() {
        return Collections.unmodifiableMap(prizes);
    }
}
