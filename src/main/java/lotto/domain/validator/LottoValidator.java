package lotto.domain.validator;

import java.util.Collections;
import java.util.List;

import static lotto.domain.generator.LottoGenerator.LOTTO_END_NUMBER;
import static lotto.domain.generator.LottoGenerator.LOTTO_START_NUMBER;

public class LottoValidator {

    private static final int MUST_LOTTO_COUNT = 6;

    public static void validateNumbers(List<Integer> lottoNumbers) {

        validateCount(lottoNumbers);
        validateNumber(lottoNumbers);
    }

    public static void validateNumber(int lottoNumber) {

        validateNumber(Collections.singletonList(lottoNumber));
    }

    private static void validateCount(List<Integer> lottoNumbers) {

        if (lottoNumbers == null || lottoNumbers.size() != MUST_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호 개수는 " + MUST_LOTTO_COUNT + "개 여야 합니다.");
        }
    }

    private static void validateNumber(List<Integer> lottoNumbers) {

        if (lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_START_NUMBER + " 이상,  " + LOTTO_END_NUMBER + " 이하 여야 합니다.");
        }
    }

    public static void validateLottosCount(int lottosCount, int purchasedLottosCount) {

        if (lottosCount != purchasedLottosCount) {
            throw new IllegalStateException("로또 개수가 유효하지 않습니다. 로또 개수=" + lottosCount + ", 구매 개수=" + purchasedLottosCount);
        }
    }
}
