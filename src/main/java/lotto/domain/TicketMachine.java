package lotto.domain;

public class TicketMachine {

    public LottoTicket createLottoTicket(NumberGenerationStrategy strategy) {
        return new LottoTicket(strategy.getNumbers());
    }
}
