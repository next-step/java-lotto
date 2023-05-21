package domain;

import static domain.LottoNumber.LOTTO_NUM_LIMIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoNumGenerator {

    private static final int LOTTO_SIZE = 6;

    private static final List<LottoNumber> LOTTO_BALLS = new ArrayList<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_BALLS.add(LottoNumber.from(i));
        }
    }

    public static LottoResult generateAutomaticResults() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Collections.shuffle(LOTTO_BALLS);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(LOTTO_BALLS.get(i));
        }

        return new LottoResult(lottoNumbers);
    }

    public static LottoResult generateManualResults(Set<Integer> manualNumbers) {
        if (LOTTO_SIZE != manualNumbers.size()) {
            throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다.");
        }
        LottoResult lottoResult = LottoResult.fromIntegers(manualNumbers);
        return lottoResult;
    }
}
