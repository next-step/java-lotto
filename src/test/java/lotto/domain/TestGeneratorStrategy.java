package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestGeneratorStrategy implements LottoNumberGenerateStrategy {

    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        return IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
