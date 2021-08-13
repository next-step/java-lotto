package lotto.domain;

import lotto.generic.Money;
import lotto.util.LottoNumbersFactory;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final Money LOTTO_PRICE = Money.wons(1000L);

    public static LottoTickets buy(Money money) {
        int ticketCounts = calculateTicketCount(money);
        List<LottoNumbers> lottoTickets = makeLottoTickets(ticketCounts);
        return new LottoTickets(lottoTickets);
    }

    private static int calculateTicketCount(Money money) {
        return money.divideAndDiscardRemainder(LOTTO_PRICE);
    }

    private static List<LottoNumbers> makeLottoTickets(int ticketCounts) {
        return IntStream.range(0, ticketCounts)
                .mapToObj((index) -> LottoNumbersFactory.makeAutoLottoNumbers())
                .collect(toList());
    }

}
