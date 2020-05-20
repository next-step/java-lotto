package lotto.domain.seller;

import lotto.domain.number.LottoTicket;
import lotto.domain.strategy.NumberGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private static final int ONE_TICKET_PRICE = 1000;

    private final NumberGenerationStrategy generationStrategy;

    private LottoSeller(final NumberGenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
    }

    public static LottoSeller of(final NumberGenerationStrategy generationStrategy) {
        return new LottoSeller(generationStrategy);
    }

    public List<LottoTicket> buyTicket(final int money) {
        validateMoney(money);
        int countTicket = money / ONE_TICKET_PRICE;

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < countTicket; i++) {
            tickets.add(LottoTicket.of(generationStrategy.generate()));
        }
        return tickets;
    }

    private void validateMoney(final int money) {
        if (money < ONE_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 금액 " + ONE_TICKET_PRICE + "원이 필요합니다.");
        }
    }
}
