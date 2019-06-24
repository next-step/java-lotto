package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    public static final Integer LOTTO_MIN_NUMBER = 1;
    public static final Integer LOTTO_MAX_NUMBER = 49;
    public static final Integer LOTTO_NUMBER_SIZE = 6;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(LottoNumber.create(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE));
    }
}
