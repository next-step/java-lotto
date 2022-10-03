package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

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
            .map(ticket -> LottoGameRank.findRank(ticket, result))
            .collect(toList());

        return new UserLottoResult(TICKET_PRICE, gameRanks);
    }
}
