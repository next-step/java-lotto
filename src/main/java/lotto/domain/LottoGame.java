package lotto.domain;

import lotto.generic.Money;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final Money LOTTO_PRICE = Money.wons(1000L);

    private static final List<Integer> lottoNumbers = IntStream
            .rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(toList());

    public static LottoTickets buy(Money money) {
        int ticketCounts = calculateTicketCount(money);
        List<LottoNumbers> lottoTickets = IntStream.range(0, ticketCounts)
                .mapToObj((index) -> makeLottoNumbers())
                .collect(toList());
        return new LottoTickets(lottoTickets);
    }

    private static int calculateTicketCount(Money money) {
        return money.divide(LOTTO_PRICE).intValue();
    }

    private static LottoNumbers makeLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoNumbers = toLottoNumbers();
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> toLottoNumbers() {
        List<Integer> integers = LottoGame.lottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE);
        Collections.sort(integers);
        return integers
                .stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

}
