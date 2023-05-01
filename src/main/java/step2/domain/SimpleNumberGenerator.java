package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleNumberGenerator implements NumberGenerator {
    private static final int DEFAULT_BOUND = 45;
    private final int bound;
    private final List<Integer> candidateNumbers = new ArrayList<>();

    public SimpleNumberGenerator() {
        this(DEFAULT_BOUND);
    }

    public SimpleNumberGenerator(int bound) {
        this.bound = bound;
        fillNumbers();
    }

    private void fillNumbers() {
        for (int i = 0; i < bound; i++) {
            candidateNumbers.add(i + 1);
        }
    }

    @Override
    public List<Integer> generateNumbers() {
        shuffle();
        List<Integer> generated = getSixNumbers();
        sort(generated);
        return generated;
    }

    private void shuffle() {
        Collections.shuffle(candidateNumbers, new Random());
    }

    private List<Integer> getSixNumbers() {
        // 깊은 복사를 위해 stream 활용
        return candidateNumbers.subList(0, 6).stream().collect(Collectors.toList());
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
