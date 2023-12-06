package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;

    private static List<LottoNumber> NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            NUMBERS.add(LottoNumber.from(i));
        }
    }

    private LottoNumbers() {}

    public static List<LottoNumber> randomList() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(MIN_SIZE, MAX_SIZE);
    }
}
