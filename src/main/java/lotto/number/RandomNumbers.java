package lotto.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private static final List<LottoNumber> candidates;
    private final int length;

    static {
        candidates = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public RandomNumbers() {
        this.length = LottoNumbers.NUMBERS_LENGTH;
    }

    public RandomNumbers(int length) {
        this.length = length;
    }

    public List<LottoNumber> lottoNumbers() {
        return pickLottoNumbers();
    }

    private List<LottoNumber> pickLottoNumbers() {
        Collections.shuffle(candidates);
        List<LottoNumber> picked = new ArrayList<>(candidates.subList(0, length));
        Collections.sort(picked);
        return picked;
    }
}
