package lotto.domain.ticket;

import lotto.domain.PurchaseAmount;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DefaultLottoTicketGenerator implements LottoTicketGenerator {
    private static final Long DUMMY_BONUS_NUMBER = 1L;

    public LottoTickets generate(PurchaseAmount purchaseAmount) {
        return LottoTickets.of(IntStream.range(0, purchaseAmount.getNumberOfTickets())
                .mapToObj(notUsed -> shuffle(generate()))
                .collect(Collectors.toList()));
    }

    private LottoTicket shuffle(List<Long> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return LottoTicket.of(lottoNumbers.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE), DUMMY_BONUS_NUMBER);
    }

    private List<Long> generate() {
        return LongStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
                .boxed()
                .collect(Collectors.toList());
    }
}
