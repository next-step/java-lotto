package lotto.model;

import java.util.List;

public class TicketMachine {

    private static final long COST_PER_TICKET = 1_000L;

    private final LottoTicketGenerator lottoTicketGenerator;

    private final Money ticketPrice;

    public TicketMachine() {
        this(new LottoTicketGenerator(), COST_PER_TICKET);
    }

    public TicketMachine(LottoTicketGenerator lottoTicketGenerator, long price) {
        this.lottoTicketGenerator = lottoTicketGenerator;
        this.ticketPrice = new Money(price);
    }

    public List<LottoTicket> buyLottoTickets(Money money) {
        int dividedNumber = (int) money.divide(ticketPrice);
        return buyLottoTickets(dividedNumber);
    }

    private List<LottoTicket> buyLottoTickets(int count) {
        return lottoTicketGenerator.generateLottoTickets(count);
    }

    public WinningTicket generateWinningTicket(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        return lottoTicketGenerator.generateWinningTicket(winningNumbers, bonusNumber);
    }

}
