package Lotto.Number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private final List<Number> randomNumbers;

    public RandomNumbers(int length, int min, int max) {
        this.randomNumbers = generate(length, min, max);
    }

    public List<Number> generate(int length, int min, int max) {
        List<Integer> candidates = getCandidatesRangedFromMinToMax(min, max);
        shuffle(candidates);
        return candidates.subList(0, length).stream().map(Number::new).collect(Collectors.toList());
    }

    private void shuffle(List<Integer> candidates) {
        Collections.shuffle(candidates);
    }

    private List<Integer> getCandidatesRangedFromMinToMax(int min, int max) {
        return IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
    }

    public List<Number> getValue() {
        return this.randomNumbers;
    }
}
