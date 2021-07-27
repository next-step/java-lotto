package lotto.auto.domain;

import lotto.auto.model.LottoGame;
import lotto.auto.strategy.LottoRule;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class LottoMachine {
    private final LottoRule lottoRule;

    private LottoMachine(final LottoRule lottoRule) {
        this.lottoRule = lottoRule;
    }

    public static LottoMachine from(final LottoRule lottoRule) {
        return new LottoMachine(lottoRule);
    }

    public List<LottoGame> ticketing(final int money) {
        return range(0, divide(money))
                .mapToObj(i -> lottoRule.ticketing())
                .collect(Collectors.toList());
    }

    private int divide(final int money) {
        return money / 1000;
    }
}
