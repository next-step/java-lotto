package step2.generator;

import step2.constants.Constants;

import java.util.Collections;
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
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                .limit(Constants.LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
