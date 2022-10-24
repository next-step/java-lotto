package domain;

import java.util.*;

public class LottoWinningsCalculator {
    private LottoWinningsCalculator() { }

    public static Price calculateWinnings(List<Lotto> lottos, Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> winningLotto.matchCount(lotto))
                .map(matchCount -> new Price(Rank.findWinningPrice(matchCount)))
                .reduce((price1, price2) -> price1.add(price2))
                .get();
    }
}
