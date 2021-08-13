package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.NotEnoughMoneyException;
import lotto.ticketingway.AutoWay;
import lotto.ticketingway.LottoTicketingWay;
import lotto.ticketingway.ManualWay;

public class LottoGameVendor {


    public static int askAvailableTicketCount(int money) {

        checkMoneyAmount(money);

        int availableTicketCount = money / LottoTicket.PRICE;

        return availableTicketCount;

    }


    private static void checkMoneyAmount(int money) {
        if (LottoTicket.PRICE > money) {
            throw new NotEnoughMoneyException(
                String.format("로또를 구입할만한 금액이 입력되지 않았습니다. 입력금액: %s", money));
        }
    }

    private static List<LottoTicket> issueTickets(int ticketCount, LottoPurchaseOrder order,
        LottoTicketingWay way) {
        return way.issueLottoTickets(ticketCount, order);
    }

    public static List<LottoTicket> buyLottos(LottoPurchaseOrder order) {
        int moneyMoney = order.getMoney();
        int availableTicketCount = askAvailableTicketCount(moneyMoney);

        int manualTicketCount = order.getManualLottoTicketCount();
        int autoTicketCount = availableTicketCount - manualTicketCount;

        List<LottoTicket> autoTickets = issueTickets(autoTicketCount, order, new AutoWay());
        List<LottoTicket> manualTickets = issueTickets(manualTicketCount, order, new ManualWay());

        return mergeTickets(autoTickets, manualTickets);

    }

    private static List<LottoTicket> mergeTickets(List<LottoTicket>... tickets) {
        return Stream.of(tickets)
            .flatMap(e -> e.stream())
            .collect(Collectors.toList());
    }
}
