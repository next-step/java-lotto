package lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private RandomNumbers() {
    }

    public static List<LottoNumber> generate() {
        List<LottoNumber> candidates = getCandidatesRangedFromMinToMax();
        shuffle(candidates);
        return pickRandomNumbers(candidates);
    }

    private static List<LottoNumber> getCandidatesRangedFromMinToMax() {
        return IntStream.rangeClosed(LottoNumberLimit.MIN.getValue(), LottoNumberLimit.MAX.getValue())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void shuffle(List<LottoNumber> candidates) {
        Collections.shuffle(candidates);
    }

    private static List<LottoNumber> pickRandomNumbers(List<LottoNumber> candidates) {
        return candidates.subList(0, LottoNumbers.NUMBERS_LENGTH);
    }
}
