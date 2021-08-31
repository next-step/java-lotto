package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private static final List<LottoNumber> candidates;

    static {
        candidates = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
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

    LottoNumber getCandidates(int index) {
        return candidates.get(index);
    }
}
