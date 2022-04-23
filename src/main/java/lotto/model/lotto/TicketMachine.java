package lotto.model.lotto;

import lotto.model.lotto.strategy.NumberGenerationStrategy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {

    private static final long PRICE_PER_TICKET = 1_000L;

    private final Money ticketPrice;

    public TicketMachine() {
        this(PRICE_PER_TICKET);
    }

    public TicketMachine(long price) {
        this.ticketPrice = new Money(price);
    }

    public List<LottoTicket> buyLottoTickets(Money money, NumberGenerationStrategy numberGenerationStrategy) {
        int ticketCount = (int) money.divide(ticketPrice);
        return IntStream.range(0, ticketCount)
                .mapToObj(index -> generateLottoTicket(numberGenerationStrategy))
                .collect(Collectors.toList());
    }

    private LottoTicket generateLottoTicket(NumberGenerationStrategy numberGenerationStrategy) {
        return new LottoTicket(numberGenerationStrategy.generateLottoNumbers());
    }

    public WinningTicket generateWinningTicket(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        return new WinningTicket(lottoNumbers, bonusNumber);
    }

}
