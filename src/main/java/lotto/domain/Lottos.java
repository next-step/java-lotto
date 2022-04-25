package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_INCLUSIVE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(int userAmount) {
        this.lottoNumbers = IntStream.range(START_INCLUSIVE, userAmount / LOTTO_PRICE)
                .mapToObj(it -> new LottoNumbers())
                .map(LottoNumbers::sort)
                .collect(Collectors.toList());
    }

    public int length() {
        return this.lottoNumbers.size();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
