package step2step3.randomNumbers;

import step2step3.lotto.lottoNumber.NumbersGenerator;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public Set<Integer> numbers() {
        final int randomNumberMin = 1;
        final int randomNumberMax = 45;

        return ThreadLocalRandom.current()
                .ints(randomNumberMin, randomNumberMax + 1)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }

}
