package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoGenerator {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoGenerator(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<Lotto> generate(int lottoCount) {
        return IntStream
                .range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoNumbersGenerator.generate()))
                .collect(Collectors.toList());
    }
}
