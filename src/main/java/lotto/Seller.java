package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    private final LottoTicketMachine lottoTicketMachine;

    public Seller(LottoTicketMachine lottoTicketMachine) {
        this.lottoTicketMachine = lottoTicketMachine;
    }

    public List<LottoTicket> sell(int money) {
        int lottoCount = money/ LottoTicket.PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(it -> lottoTicketMachine.issue())
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean hasSameMachine(LottoTicketMachine lottoTicketMachine) {
        return this.lottoTicketMachine == lottoTicketMachine;
    }
}
