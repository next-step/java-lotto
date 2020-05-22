package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {
    protected static int getLottoTicketCount(Money money) {
        return (int) (money.getValue() / 1000);
    }

    public static LottoTickets buyLottoTickets(Money money) {
        int lottoTicketCount = getLottoTicketCount(money);
        List<LottoTicket> lottoTicketList = IntStream.range(0, lottoTicketCount)
                .mapToObj(num -> LottoGenerator.create())
                .collect(Collectors.toList());
        return LottoTickets.create(lottoTicketList);
    }
}
