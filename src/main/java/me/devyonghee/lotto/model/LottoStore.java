package me.devyonghee.lotto.model;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoStore {

    public static final int LOTTO_PRICE = 1_000;
    private static final int START_SALE_INDEX = 0;
    private static final int MIN_MONEY = 0;
    private static final String NEGATIVE_MONEY_ERROR_MESSAGE = "money(%d) must not be negative";
    private static final String NULL_GENERATOR_ERROR_MESSAGE = "generator must not be null";

    private final int money;
    private final LottoTicketGenerator generator;

    private LottoStore(int money, LottoTicketGenerator generator) {
        Objects.requireNonNull(generator, NULL_GENERATOR_ERROR_MESSAGE);
        validateNegative(money);
        this.generator = generator;
        this.money = money;
    }

    public static LottoStore of(int money, LottoTicketGenerator generator) {
        return new LottoStore(money, generator);
    }

    public LottoTickets lottoTickets() {
        return LottoTickets.from(
                IntStream.range(START_SALE_INDEX, availableQuantity())
                        .mapToObj(i -> generator.lottoTicket())
                        .collect(Collectors.toList())
        );
    }

    private void validateNegative(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(String.format(NEGATIVE_MONEY_ERROR_MESSAGE, money));
        }
    }

    private int availableQuantity() {
        return money / LOTTO_PRICE;
    }
}
