package Lotto.Number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private final List<LottoNumber> randomNumbers;
    private final int length;
    private final int min;
    private final int max;

    public RandomNumbers(int length, int min, int max) {
        this.length = length;
        this.min = min;
        this.max = max;
        this.randomNumbers = generate();
    }

    public List<LottoNumber> generate() {
        List<Integer> candidates = getCandidatesRangedFromMinToMax();
        shuffle(candidates);
        return pickRandomNumbers(candidates);
    }

    private List<LottoNumber> pickRandomNumbers(List<Integer> candidates) {
        return candidates.subList(0, length).stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void shuffle(List<Integer> candidates) {
        Collections.shuffle(candidates);
    }

    private List<Integer> getCandidatesRangedFromMinToMax() {
        return IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
    }

    public List<LottoNumber> getValue() {
        return this.randomNumbers;
    }
}
