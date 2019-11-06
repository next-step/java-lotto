package lottery.domain;

import java.util.List;
import lottery.LottoConstants;

public class LottoTicketSeller {

    private static final String NOT_ENOUGH_MONEY = "로또 구입 금액이 부족합니다.";

    public static LottoTickets purchaseRandomGames(int purchaseAmount) {
        return new LottoTickets(generateRandomGames(getNumberOfTicket(purchaseAmount)));
    }

    private static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return LottoTicketFactory.generateRandomGames(numberOfTicket);
    }

    private static Integer getNumberOfTicket(int purchaseAmount) {
        Integer numberOfTickets = purchaseAmount / LottoConstants.TICKET_PRICE;
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return numberOfTickets;
    }
}
