package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGeneration implements NumberGenerationStrategy {

    @Override
    public List<Integer> generateNumbers() {

        List<Integer> pool = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(pool);

        return pool.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
