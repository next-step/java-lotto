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

    public static LottoResult generateResult() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Collections.shuffle(LOTTO_BALLS);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(LOTTO_BALLS.get(i));
        }

        return new LottoResult(lottoNumbers);
    }

    public static LottoNumber[] generateManualNumbers(int[] manualNumbers) {

        return new LottoNumber[0];
    }
}
