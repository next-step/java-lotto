package lotto;

import java.util.List;
import lotto.view.OutputView;

public class LottoSeller {

    private static int LOTTO_TICKET_PRICE = 1_000;

    private LottoMachine lottoMachine;
    private int ticketCount;

    public LottoSeller(int money) {
        validate(money);
        this.ticketCount = money / LOTTO_TICKET_PRICE;
        this.lottoMachine = new LottoMachine();

        OutputView.printTicketCount(ticketCount);
    }

    private void validate(int money) {
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
    }

    public List<LottoTicket> sellTickets() {
        return lottoMachine.issueTickets(ticketCount);
    }

    public LottoTicket getWinningTicket(String winningNumbers) {
        return lottoMachine.issueTicket(winningNumbers);
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
