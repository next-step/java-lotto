package lotto.domain;

import lotto.domain.enums.LottoGameRank;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.Money;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketSeller {
    private static final Money TICKET_PRICE = new Money(1_000);
    private static final TicketMachine TICKET_MACHINE = new TicketMachine();

    public static void sellTicketTo(User user) {
        while (user.hasEnoughMoney(TICKET_PRICE)) {
            user.buyTicket(TICKET_MACHINE.createLottoTicket(new RandomNumberGenerationStrategy()), TICKET_PRICE);
        }
    }

    public static UserLottoResult verifyRankFor(User user, LottoResult result) {
        List<LottoGameRank> gameRanks = user.getLottoTickets().stream()
            .map(ticket -> TICKET_MACHINE.verifyRank(ticket, result))
            .collect(toList());

        return new UserLottoResult(TICKET_PRICE, gameRanks);
    }
}
