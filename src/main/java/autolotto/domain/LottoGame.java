package autolotto.domain;

import autolotto.strategy.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> getLottoTickets(int ticketCount) {
        return Optional.ofNullable(IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateNumbers()))
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }
    public List<Lotto> getLottoTickets(List<List<Integer>> manualNumbers) {
        return Optional.ofNullable(manualNumbers.stream()
                        .map(Lotto::new)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
