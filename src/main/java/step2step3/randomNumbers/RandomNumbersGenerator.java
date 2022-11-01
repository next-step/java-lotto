package step2step3.randomNumbers;

import step2step3.lotto.NumbersGenerator;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public Set<Integer> numbers() {
        return ThreadLocalRandom.current()
                .ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }

}
