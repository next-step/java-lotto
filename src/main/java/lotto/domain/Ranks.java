package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranks {
    private List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = Collections.unmodifiableList(new ArrayList<>(ranks));
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public int getTotalWinningMoney() {
        return ranks.stream()
                .map(Rank::getWinningMoney)
                .reduce(0, Integer::sum);
    }
}
