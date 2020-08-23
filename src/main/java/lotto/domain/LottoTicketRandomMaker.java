package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class LottoTicketRandomMaker implements LottoTicketMaker {
    public static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = Stream.iterate(LottoNumber.MIN_VALUE, number -> number + 1)
                .limit(LottoNumber.MAX_VALUE)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoTicket> create(BuyCount buyCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (buyCount.canBuy()) {
            Collections.shuffle(LOTTO_NUMBERS);

            LottoTicket lottoTicket = LOTTO_NUMBERS.stream()
                    .limit(DEFAULT_LOTTO_NUMBER_COUNT)
                    .collect(collectingAndThen(Collectors.toList(), LottoTicket::of));

            lottoTickets.add(lottoTicket);
            buyCount.subtract();
        }

        return lottoTickets;
    }
}
