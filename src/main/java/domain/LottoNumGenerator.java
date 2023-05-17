package domain;

import static domain.LottoNumber.LOTTO_NUM_LIMIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumGenerator {

    private static final int LOTTO_SIZE = 6;

    private static final List<LottoNumber> LOTTO_BALLS = new ArrayList<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_BALLS.add(LottoNumber.from(i));
        }
    }

    public static LottoNumber[] generateNumbers() {
        LottoNumber[] generatedNumbers = new LottoNumber[LOTTO_SIZE];
        Collections.shuffle(LOTTO_BALLS);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            generatedNumbers[i] = LOTTO_BALLS.get(i);
        }

        return generatedNumbers;
    }
}
