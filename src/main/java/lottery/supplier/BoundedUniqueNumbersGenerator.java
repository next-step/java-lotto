package lottery.supplier;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoundedUniqueNumbersGenerator implements NumbersGenerator {

    private final Random random;

    private final int lowerBoundInclusive;
    private final int upperBoundInclusive;

    public BoundedUniqueNumbersGenerator(int lowerBoundInclusive, int upperBoundInclusive) {
        if (lowerBoundInclusive > upperBoundInclusive) {
            throw new IllegalArgumentException("lowerBoundInclusive must be less than or equal to upperBoundInclusive");
        }
        this.lowerBoundInclusive = lowerBoundInclusive;
        this.upperBoundInclusive = upperBoundInclusive;
        random = new Random();
    }

    @Override
    public List<Integer> nextNumbers(int size) {
        return createShuffleNumbers().stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    private List<Integer> createShuffleNumbers() {
        final List<Integer> collect = IntStream.rangeClosed(lowerBoundInclusive, upperBoundInclusive)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(collect, random);
        return collect;
    }
}
