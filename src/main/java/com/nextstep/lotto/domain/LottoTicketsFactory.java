package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoTicketsFactory {
    public static LottoTickets createAuto(Money money) {
        LottoTicketCreatePolicy createPolicy = new AutoCreatePolicy();

        List<LottoTicket> lottoTickets = LongStream.range(0, money.howManyLottoTickets())
                .mapToObj(number -> LottoTicket.of(createPolicy))
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }
}
