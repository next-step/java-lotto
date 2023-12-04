package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<LottoNumbers> lottoTicket;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoTicket = lottoNumbers;
    }

    public LottoTicket(int numberOfTickets) {
        this.lottoTicket = generateTicket(numberOfTickets);
    }

    private List<LottoNumbers> generateTicket(int numberOfTickets) {
        return Stream.generate(LottoNumbers::new)
                .limit(numberOfTickets)
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }
}
