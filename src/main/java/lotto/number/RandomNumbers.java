package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private final List<LottoNumber> candidates;
    private final int min;
    private final int max;
    private final int length;

    public RandomNumbers(int min, int max, int length) {
        this.min = min;
        this.max = max;
        this.length = length;
        candidates = candidatesInRange();
    }

    public List<LottoNumber> value() {
        shuffleNumbers();
        return numbers();
    }

    private List<LottoNumber> candidatesInRange() {
        return IntStream.rangeClosed(this.min, this.max)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void shuffleNumbers() {
        Collections.shuffle(candidates);
    }

    private List<LottoNumber> numbers() {
        List<LottoNumber> picked = candidates.subList(0, this.length);
        Collections.sort(picked);
        return picked;
    }
}
