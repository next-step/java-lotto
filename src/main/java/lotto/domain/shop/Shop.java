package lotto.domain.shop;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.shop.exceptions.ExceedTotalLottoTicketsCountInMoney;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {
    public static LottoTickets sellLottoTicketsAuto(Money money) {
        int lottoTicketCount = money.howManyLottoTickets();
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(num -> LottoGenerator.create())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::create));
    }

    public static LottoTickets sellLottoTicketsAutoAndManual(LottoTickets manualLottoTickets, Money money) {
        int autoCount = countAutoLottoTickets(manualLottoTickets, money);
        LottoTickets lottoTicketsByAuto = getLottoTicketsByAuto(autoCount);

        return manualLottoTickets.combine(lottoTicketsByAuto);
    }

    protected static int countAutoLottoTickets(LottoTickets manualLottoTickets, Money money) {
        countAutoLottoTicketValidation(manualLottoTickets, money);
        return money.howManyLottoTickets() - manualLottoTickets.size();
    }

    private static void countAutoLottoTicketValidation(LottoTickets manualLottoTickets, Money money) {
        if (manualLottoTickets.size() > money.howManyLottoTickets()) {
            throw new ExceedTotalLottoTicketsCountInMoney("You can't by LottoTickets over you money");
        }
    }

    private static LottoTickets getLottoTicketsByAuto(int count) {
        return IntStream.range(0, count)
                .mapToObj(num -> LottoGenerator.create())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::create));
    }
}
