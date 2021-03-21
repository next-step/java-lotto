package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private final static LottoNumbers LOTTO_NUMBERS = new LottoNumbers();

    private LottoGenerator() { }

    public static List<Lotto> generate(int quantity) {
        return Stream.generate(LOTTO_NUMBERS::lottoNumbers)
                .limit(quantity)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
