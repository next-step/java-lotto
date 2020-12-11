package com.nextstep.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoCreatePolicy implements LottoTicketCreatePolicy {
    private static final int LOTTO_NUMBERS_CUTTER_START = 0;
    private static final int LOTTO_NUMBERS_CUTTER_END = 6;

    private static final List<LottoNumber> lottoNumbers =
            IntStream.rangeClosed(LottoNumber.MIN_SIZE, LottoNumber.MAX_SIZE)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());

    @Override
    public LottoTicket create() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> newTicketNumbers = AutoCreatePolicy.lottoNumbers
                .subList(LOTTO_NUMBERS_CUTTER_START, LOTTO_NUMBERS_CUTTER_END);

        return new LottoTicket(newTicketNumbers);
    }
}
