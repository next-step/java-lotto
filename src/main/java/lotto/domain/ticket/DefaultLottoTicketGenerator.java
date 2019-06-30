package lotto.domain.ticket;

import lotto.domain.PurchaseAmount;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DefaultLottoTicketGenerator implements LottoTicketGenerator {
    private static final Integer RANGE_CORRECTION_NUMBER = 1;     // 0~44 -> 1~45
    private Random random = new Random();

    public LottoTickets generate(PurchaseAmount purchaseAmount) {
        return LottoTickets.of(IntStream.range(0, purchaseAmount.getNumberOfTickets())
                .mapToObj(notUsed -> shuffle(generate()))
                .collect(Collectors.toList()));
    }

    private LottoTicket shuffle(List<Long> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return LottoTicket.of(lottoNumbers.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE), generateBonusNumber());
    }

    private List<Long> generate() {
         return LongStream.rangeClosed(LOTTO_NUM_START, LOTTO_NUM_END)
                .boxed()
                .collect(Collectors.toList());
    }

    private Long generateBonusNumber() {
        return (long) random.nextInt(LottoNumber.LOTTO_NUMBER_MAX.intValue()) + RANGE_CORRECTION_NUMBER;
    }
}
