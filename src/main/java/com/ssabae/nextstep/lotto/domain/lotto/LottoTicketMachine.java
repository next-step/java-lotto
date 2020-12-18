package com.ssabae.nextstep.lotto.domain.lotto;

import static com.ssabae.nextstep.lotto.domain.lotto.LottoConstant.LOTTO_TICKET_PRICE;

import com.ssabae.nextstep.lotto.domain.Money;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class LottoTicketMachine {

    private final LottoTicketGenerator generator;

    public LottoTicketMachine(LottoTicketGenerator generator) {
        this.generator = generator;
    }

    public LottoTickets buy(Money amount) {
        int count = calculateTicketCount(amount);
        List<LottoTicket> lottoTicketList = Stream.generate(generator::generate)
                .limit(count)
                .collect(Collectors.toList());
        return new LottoTickets(Collections.unmodifiableList(lottoTicketList));
    }

    private int calculateTicketCount(Money amount) {
        return amount.amount
                .divide(LOTTO_TICKET_PRICE.amount, 1, BigDecimal.ROUND_UP)
                .intValue();
    }
}
