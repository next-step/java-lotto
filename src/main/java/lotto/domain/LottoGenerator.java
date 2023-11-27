package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private final int amount;
    private final LottoNumbers lottoNumbers;

    public LottoGenerator(int amount, LottoNumbers lottoNumbers) {
        this.amount = amount;
        this.lottoNumbers = lottoNumbers;
    }

    public Lottos lottos() {
        return new Lottos(generate());
    }

    private List<Lotto> generate() {
        return Stream.generate(() -> new Lotto(lottoNumbers.lottoNumbers())).limit(amount).collect(Collectors.toList());
    }
}
