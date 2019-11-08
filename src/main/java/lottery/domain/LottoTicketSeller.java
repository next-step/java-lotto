package lottery.domain;

import java.util.List;

public class LottoTicketSeller {

    public static LottoTickets purchaseRandomGames(LottoMoney purchaseAmount) {
        return new LottoTickets(generateRandomGames(purchaseAmount.getNumberOfTickets()));
    }

    private static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return LottoTicketFactory.generateRandomGames(numberOfTicket);
    }
}
