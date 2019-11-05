package lottery.domain;

import java.util.List;

public class LottoTicketSeller {

    private static final Integer TICKET_PRICE = 1000;
    private static final String NOT_ENOUGH_MONEY = "로또 구입 금액이 부족합니다.";

    public LottoTickets purchaseRandomGames(int purchaseAmount) {
        return new LottoTickets(generateRandomGames(getNumberOfTicket(purchaseAmount)));
    }

    private List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return LottoTicketFactory.generateRandomGames(numberOfTicket);
    }

    private Integer getNumberOfTicket(int purchaseAmount) {
        Integer numberOfTickets = purchaseAmount / TICKET_PRICE;
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return numberOfTickets;
    }
}
