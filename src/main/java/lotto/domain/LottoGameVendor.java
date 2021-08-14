package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.NotEnoughMoneyException;
import lotto.exception.WrongTicketCountException;

public class LottoGameVendor {

    public static LottoTicketBundle buyLottos(LottoPurchaseOrder order) {

        TicketCount available = getAvailableTicketCount(order);
        TicketCount manual = order.getManualLottoTicketCount();
        TicketCount auto = getAutoTicketCount(available, manual);

        LottoTicketMachine ticketMachine = LottoTicketMachine.getInstance();
        List<LottoTicket> autoTickets = ticketMachine.issueTicketsByAutoWay(auto, order);
        List<LottoTicket> manualTickets = ticketMachine.issueTicketsByManualWay(manual, order);

        return new LottoTicketBundle(autoTickets, manualTickets);

    }


    private static TicketCount getAvailableTicketCount(LottoPurchaseOrder order) {
        Money gameMoney = order.getGameMoney();
        checkMoneyAmount(gameMoney);

        int availableTicketCount = gameMoney.value() / LottoTicket.PRICE;

        return new TicketCount(availableTicketCount);

    }


    private static void checkMoneyAmount(Money gameMoney) {
        if (LottoTicket.PRICE > gameMoney.value()) {
            throw new NotEnoughMoneyException(
                String.format("로또를 구입할만한 금액이 입력되지 않았습니다. 입력금액: %s", gameMoney));
        }
    }

    private static TicketCount getAutoTicketCount(TicketCount availableCount,
        TicketCount manualCount) {

        TicketCount autoCount;
        try {
            autoCount = availableCount.minus(manualCount);
        } catch (WrongTicketCountException e) {
            throw new WrongTicketCountException("수동입력 티켓장수는 구매가능한 전체티켓 장수를 초과할 수 없습니다.");
        }
        return autoCount;
    }

    private static List<LottoTicket> mergeTickets(List<LottoTicket>... tickets) {
        return Stream.of(tickets)
            .flatMap(e -> e.stream())
            .collect(Collectors.toList());
    }
}
