package lotto.domain;

import java.util.List;
import lotto.exception.NotEnoughMoneyException;
import lotto.ticketingway.LottoTicketingWay;

public class LottoTicketVendor {

    private final LottoTicketingWay ticketingWay;

    public LottoTicketVendor(LottoTicketingWay ticketingWay) {
        this.ticketingWay = ticketingWay;
    }


    public List<LottoTicket> buyLottoTickets(int money) {

        checkMoneyAmount(money);

        int availableTicketCount = money / LottoTicket.PRICE;

        return ticketingWay.issueLottoTickets(availableTicketCount);

    }

    private void checkMoneyAmount(int money) {
        if (money == 0 || LottoTicket.PRICE > money) {
            throw new NotEnoughMoneyException(
                String.format("로또를 구입할만한 금액이 입력되지 않았습니다. 입력금액: %s", money));
        }
    }
}
