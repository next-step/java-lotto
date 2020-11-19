package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TesterLottoGenerator implements LottoGenerator {

    @Override
    public Set<LottoNumber> create() {
        // 1,2,3,4,5,6
        return IntStream.range(1, 7)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
