package autolotto.domain;

import autolotto.strategy.LottoNumberGenerator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private int ticketCount;
    private LottoNumberGenerator lottoNumberGenerator;
    private Lotto lotto;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Optional<List<Lotto>> getLottoTickets(int ticketCount) {
        return Optional.of(IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateNumbers()))
                .collect(Collectors.toList()));
    }
}
