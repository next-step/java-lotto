package com.ssabae.nextstep.lotto.domain.lotto;

import com.ssabae.nextstep.lotto.domain.Money;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class LottoTicketMachine {

    private final static Money LOTTO_TICKET_PRICE = Money.won(1_000L);

    private final LottoTicketGenerator generator;

    public LottoTicketMachine(LottoTicketGenerator generator) {
        this.generator = generator;
    }

    public List<LottoTicket> buy(Money amount) {
        int count = calculateTicketCount(amount);
        return Stream.generate(generator::generate)
                .limit(count)
                .collect(Collectors.toList());
    }

    private int calculateTicketCount(Money amount) {
        return amount.amount
                .divide(LOTTO_TICKET_PRICE.amount, 1, BigDecimal.ROUND_UP)
                .intValue();
    }
}
