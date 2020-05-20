package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {
    public static int getLottoTicketCount(long money) {
        moneyValidation(money);
        return (int) (money / 1000);
    }

    private static void moneyValidation(long money) {
        if (money % 1000 != 0 || money == 0) throw new IllegalArgumentException();
    }

    public static LottoTickets buyLottoTickets(long money) {
        int lottoTicketCount = getLottoTicketCount(money);
        List<LottoTicket> lottoTicketList = IntStream.range(0, lottoTicketCount)
                .mapToObj(num -> LottoGenerator.create())
                .collect(Collectors.toList());
        return LottoTickets.create(lottoTicketList);
    }
}
