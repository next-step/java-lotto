package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    private final LottoTicketMachine lottoTicketMachine;

    public Seller() {
        this.lottoTicketMachine = new LottoTicketMachine(new Random());
    }

    public List<LottoTicket> sell(int money) {
        int lottoCount = money/ LottoTicket.PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(it -> lottoTicketMachine.issue())
                .collect(Collectors.toUnmodifiableList());
    }
}
