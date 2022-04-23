package lotto.model.lotto;

import lotto.model.lotto.strategy.NumberGenerationStrategy;

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

    public List<LottoTicket> buyLottoTickets(Money money, NumberGenerationStrategy numberGenerationStrategy) {
        int dividedNumber = (int) money.divide(ticketPrice);
        return buyLottoTickets(dividedNumber, numberGenerationStrategy);
    }

    private List<LottoTicket> buyLottoTickets(int count, NumberGenerationStrategy numberGenerationStrategy) {
        return lottoTicketGenerator.generateLottoTickets(count, numberGenerationStrategy);
    }

    public WinningTicket generateWinningTicket(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        return lottoTicketGenerator.generateWinningTicket(winningNumbers, bonusNumber);
    }

}
