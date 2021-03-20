package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private final static LottoNumbers lottoNumbers = new LottoNumbers();

    private LottoGenerator() { }

    public static List<Lotto> generate(int quantity) {
        return Stream.generate(lottoNumbers::lottoNumbers)
                .limit(quantity)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
