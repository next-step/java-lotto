package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    private static final int DEFAULT_BOUND = 45;
    private final int bound;
    private final List<Integer> candidateNumbers = new ArrayList<>();

    public NumberGenerator() {
        this(DEFAULT_BOUND);
    }

    public NumberGenerator(int bound) {
        this.bound = bound;
        fillNumbers();
    }

    private void fillNumbers() {
        for (int i = 0; i < bound; i++) {
            candidateNumbers.add(i + 1);
        }
    }

    public List<Integer> generateNumbers() {
        List<Integer> generated = getNumbers();
        sort(generated);
        return generated;
    }

    private List<Integer> getNumbers() {
        shuffle();
        return candidateNumbers.subList(0, 6);
    }

    private void shuffle() {
        Collections.shuffle(candidateNumbers);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

}
