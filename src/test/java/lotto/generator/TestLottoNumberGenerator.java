package lotto.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestLottoNumberGenerator implements NumberGenerator {
    private static final List<Integer> allLottoNumbers =
            IntStream.rangeClosed(1, 6)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public List<Integer> generator() {
        return allLottoNumbers;
    }
}
