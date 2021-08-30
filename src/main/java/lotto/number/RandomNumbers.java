package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private final List<LottoNumber> candidates;

    public RandomNumbers() {
        candidates = candidatesInRange();
    }

    private List<LottoNumber> candidatesInRange() {
        return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> value() {
        shuffleNumbers();
        return numbers();
    }

    private void shuffleNumbers() {
        Collections.shuffle(candidates);
    }

    private List<LottoNumber> numbers() {
        List<LottoNumber> picked = candidates.subList(0, LottoNumbers.NUMBERS_LENGTH);
        Collections.sort(picked);
        return picked;
    }
}
