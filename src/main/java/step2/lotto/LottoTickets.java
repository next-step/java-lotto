package step2.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int price, NumbersGenerator numbersGenerator) {
        int numberOfTickets = price / LOTTO_PRICE;

        List<LottoTicket> lottoTickets = IntStream.range(0, numberOfTickets)
                .mapToObj(numberOfTicket -> LottoTicket.from(numbersGenerator))
                .collect(Collectors.toUnmodifiableList());

        return new LottoTickets(lottoTickets);
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }
}
