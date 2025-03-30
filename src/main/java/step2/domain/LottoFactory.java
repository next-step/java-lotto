package step2.domain;

import step2.util.LottoStrategy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final String SEPARATOR = ",";

    private final LottoStrategy lottoStrategy;

    public LottoFactory(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public static Set<LottoNum> fromSplit(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNum::new)
                .collect(Collectors.toSet());
    }

    public Lottos buy(LottosCount lottosCount) {
        return new Lottos(
                IntStream.range(0, lottosCount.getAuto())
                        .mapToObj(i -> new Lotto(lottoStrategy.generateLottoNumbers()))
                        .collect(Collectors.toList()));
    }

}
