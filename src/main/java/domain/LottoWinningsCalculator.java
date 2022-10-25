package domain;

import java.util.*;

public class LottoWinningsCalculator {
    private LottoWinningsCalculator() { }

    public static Price calculateWinnings(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> winningLotto.getRank(lotto).getWinningPrice())
                .map(Price::new)
                .reduce((price1, price2) -> price1.add(price2))
                .get();
    }
}
