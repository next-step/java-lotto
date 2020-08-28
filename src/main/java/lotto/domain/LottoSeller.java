package lotto.domain;

import java.util.List;
import lotto.common.LottoTicketMachine;

public class LottoSeller {

    private static final int LOTTO_TICKET_PRICE = 1_000;

    private int ticketCount;

    public LottoSeller(int money) {
        validate(money);
        this.ticketCount = money / LOTTO_TICKET_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
    }

    public LottoPackage sellTickets() {
        return LottoTicketMachine.issueTickets(ticketCount);
    }

    public LottoTicket getWinningTicket(String winningNumbers) {
        return LottoTicketMachine.issueTicket(winningNumbers);
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
