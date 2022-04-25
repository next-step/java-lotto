package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(int lottoAmount) {
        this.lottoNumbers = IntStream.range(START_INCLUSIVE, lottoAmount)
                .mapToObj(it -> new LottoNumbers())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
