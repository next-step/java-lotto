package step2.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public LottoNumbers generate() {
        List<Integer> randomNumbers = random.ints(LottoNumbers.MIN_NUMBER, LottoNumbers.MAX_NUMBER + 1)
                                            .limit(LottoNumbers.COUNT)
                                            .boxed()
                                            .collect(Collectors.toList());
        return new LottoNumbers(randomNumbers);
    }
}
