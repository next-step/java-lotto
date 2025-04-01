package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    private final LottoTicketMachine lottoTicketMachine;

    public static final int PRICE = 1000;

    public Seller() {
        this.lottoTicketMachine = new LottoTicketMachine(new Random());
    }

    public List<LottoTicket> sell(int money) {
        int lottoCount = money/ PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(it -> lottoTicketMachine.issue())
                .collect(Collectors.toUnmodifiableList());
    }
}
