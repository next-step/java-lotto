package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {
    public static LottoTickets sellLottoTickets(Money money) {
        int lottoTicketCount = money.howManyLottoTickets();
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(num -> LottoGenerator.create())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::create));
    }
}
