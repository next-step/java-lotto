package lotto.domain.strategy;

import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LottoCreationStrategy {
    private static final int LOTTO_PRICE = 1000;
    public abstract LottoTickets createLottoTickets();

    protected int calculateLottoTicketCount(final int price) {
        checkPrice(price);
        return price / LOTTO_PRICE;
    }

    protected void checkPrice(final int price) {
        if (price < LOTTO_PRICE) {
            String message = String.format("로또 가격은 %d원 입니다. 잔액이 부족 합니다. price: %d", LOTTO_PRICE, price);
            throw new IllegalArgumentException(message);
        }
    }

    protected List<Integer> toIntegerList(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
