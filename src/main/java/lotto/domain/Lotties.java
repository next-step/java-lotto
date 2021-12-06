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

    public ResultRank gameResultRank(WinLotto winLotto) {
        return new ResultRank(this.lotties.stream()
                .map(lotto -> winLotto.getRank(lotto))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting())));
    }

    public void addLotties(Lotties lotties) {
        this.lotties.addAll(lotties.getLotties());
    }
}
