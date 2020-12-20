package com.ssabae.nextstep.lotto.domain.lotto;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_TICKET_PRICE;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.LottoTicketsAnalyzer;
import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.LottoTicketGenerator;
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

    private final LottoTicketsAnalyzer analyzer;

    public LottoTicketMachine(LottoTicketGenerator generator) {
        this.generator = generator;
        this.analyzer = new LottoTicketsAnalyzer();
    }

    public LottoTickets buy(Money amount) {
        validate(amount);
        int count = calculateTicketCount(amount);
        List<LottoTicket> lottoTicketList = Stream.generate(generator::generate)
                .limit(count)
                .collect(Collectors.toList());
        return new LottoTickets(Collections.unmodifiableList(lottoTicketList));
    }

    public LottoResultDto calculateYield(LottoTickets lottoTickets, WinningNumber winningNumber) {
        return this.analyzer.convertToDto(lottoTickets, winningNumber);
    }

    private void validate(Money amount) {
        if (amount.isLessThen(LOTTO_TICKET_PRICE)) {
            throw new IllegalArgumentException(LOTTO_TICKET_PRICE + "원 이상이여야 합니다.");
        }
    }

    private int calculateTicketCount(Money amount) {
        return (int) (amount.getAmountLongValue() / LOTTO_TICKET_PRICE.getAmountLongValue());
    }
}
