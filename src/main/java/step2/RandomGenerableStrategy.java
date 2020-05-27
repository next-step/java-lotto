package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step0.GenerableStrategy;

public class RandomGenerableStrategy implements GenerableStrategy {

    @Override
    public List<Integer> generate(int count) {

        return null;
    }

    private List<Integer> makeSequentialNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
            .boxed()
            .collect(Collectors.toList());
    }
}
