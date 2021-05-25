package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또번호 자동 생성기.
 */
public class LottoNumberGenerator {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_COUNT = 6;

    private LottoNumberGenerator() {
    }

    /**
     * 로또번호 목록을 가져온다.
     *
     * @return 생성된 로또 번호 목록
     */
    public static List<LottoNumber> getLottoNumbers() {
        final List<LottoNumber> numbers = createNumbers();
        return numbers.subList(0, MAX_LOTTO_COUNT);
    }

    private static List<LottoNumber> createNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_NUMBER; i < MAXIMUM_LOTTO_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
        return shuffle(lottoNumbers);
    }

    private static List<LottoNumber> shuffle(final List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
