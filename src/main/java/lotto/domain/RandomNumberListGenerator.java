package lotto.domain;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberListGenerator implements NumberListGenerator {
    private Random random = new Random();

    @Override
    public Set<Integer> generate() {
        return random.ints(6, 1, 46)
                .boxed()
                .collect(Collectors.toSet());
    }
}
