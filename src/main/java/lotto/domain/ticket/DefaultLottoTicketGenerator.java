package lotto.domain.ticket;

import lotto.domain.PurchaseAmount;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DefaultLottoTicketGenerator implements LottoTicketGenerator {
    private static final Long LOTTO_NUM_START = 1L;
    private static final Long LOTTO_NUM_END = 45L;
    private static final Integer LOTTO_NUM_CNT = 6;

    public LottoTickets generate(PurchaseAmount purchaseAmount) {
        return LottoTickets.of(IntStream.range(0, purchaseAmount.getNumberOfTickets())
                .mapToObj(notUsed -> shuffle(generate()))
                .collect(Collectors.toList()));
    }

    private LottoTicket shuffle(List<Long> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return LottoTicket.of(lottoNumbers.subList(0, LOTTO_NUM_CNT));
    }

    private List<Long> generate() {
         return LongStream.rangeClosed(LOTTO_NUM_START, LOTTO_NUM_END)
                .boxed()
                .collect(Collectors.toList());
    }
}
