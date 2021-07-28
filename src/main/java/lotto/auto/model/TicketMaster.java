package lotto.auto.model;

import lotto.auto.strategy.LottoRule;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static lotto.auto.context.ConstantContext.GAME_PRICE;

public class TicketMaster {
    private final LottoRule lottoRule;

    private TicketMaster(final LottoRule lottoRule) {
        this.lottoRule = lottoRule;
    }

    public static TicketMaster init(final LottoRule lottoRule) {
        Objects.requireNonNull(lottoRule);
        return new TicketMaster(lottoRule);
    }

    public List<LottoGame> ticketing(final int money) {
        if (money < GAME_PRICE) {
            throw new IllegalArgumentException("don't have enough money.");
        }
        return range(0, divide(money))
                .mapToObj(i -> lottoRule.ticketing())
                .collect(toList());
    }

    private int divide(final int money) {
        return money / GAME_PRICE;
    }
}
