package autolotto.domain;

import autolotto.strategy.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private int ticketCount;

    private LottoNumberGenerator lottoNumberGenerator;

    public LottoGame(int ticketCount, LottoNumberGenerator lottoNumberGenerator) {
        this.ticketCount = ticketCount;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> getLottoTickets() {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateNumbers()))
                .collect(Collectors.toList());
    }
}
