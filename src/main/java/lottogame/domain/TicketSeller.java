package lottogame.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import lottogame.domain.enums.LottoGameRank;
import lottogame.domain.lotto.LottoResult;
import lottogame.domain.strategy.LottoNumberGenerationStrategy;
import lottogame.domain.strategy.RangeLottoNumberPickerStrategy;
import lottogame.domain.user.User;
import lottogame.domain.user.UserLottoResult;

public class TicketSeller {
    private static final TicketMachine TICKET_MACHINE = new TicketMachine();
    private static final Money TICKET_PRICE = new Money(1_000);

    public static void sellManualTicketTo(User user, LottoNumberGenerationStrategy strategy) {
        if (user.hasEnoughMoney(TICKET_PRICE)) {
            sellTicketTo(user, strategy);
        }
    }

    public static void sellAutomaticTicketTo(User user) {
        while (user.hasEnoughMoney(TICKET_PRICE)) {
            sellTicketTo(user, new RangeLottoNumberPickerStrategy());
        }
    }

    public static UserLottoResult verifyRankFor(User user, LottoResult result) {
        List<LottoGameRank> gameRanks = user.getLottoTickets().stream()
            .map(ticket -> TICKET_MACHINE.verifyRank(ticket, result))
            .collect(toList());

        return new UserLottoResult(TICKET_PRICE, gameRanks);
    }

    private static void sellTicketTo(User user, LottoNumberGenerationStrategy strategy) {
        user.buyTicket(TICKET_MACHINE.createLottoTicket(strategy), TICKET_PRICE);
    }

    public static Money getTicketPrice() {
        return TICKET_PRICE;
    }
}


