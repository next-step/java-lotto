package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<LottoNumbers> lottoTicket;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoTicket = lottoNumbers;
    }

    public LottoTicket(int numberOfTickets) {
        this.lottoTicket = generateTicket(numberOfTickets);
    }

    private List<LottoNumbers> generateTicket(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(i -> new LottoNumbers())
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }
}
