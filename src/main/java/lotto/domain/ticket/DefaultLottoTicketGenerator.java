package lotto.domain.ticket;

import lotto.common.PositiveNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultLottoTicketGenerator implements LottoTicketGenerator {

    @Override
    public LottoTickets generate(PositiveNumber ticketCount) {
        return LottoTickets.of(LongStream.range(0, ticketCount.get())
                .mapToObj(notUsed -> shuffle(generate()))
                .collect(Collectors.toList()));
    }

    private LottoTicket shuffle(List<Long> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return LottoTicket.of(LottoNumbers.of(lottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE)));
    }

    private List<Long> generate() {
        return LongStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
                .boxed()
                .collect(Collectors.toList());
    }
}
