package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(this.lotties);
    }

    public int purchaseLottiesCount() {
        return this.lotties.size();
    }

    public int getLottiesPrice() {
        return Store.LOTTO_ONE_GAME_PRICE * this.purchaseLottiesCount();
    }

    public ResultRank gameResultRank(Lotto winLotto) {
        return new ResultRank(this.lotties.stream()
                .map(winLotto::getRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting())));
    }
}
