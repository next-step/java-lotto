package lotto.domain;

import java.util.Set;

import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_LOWER_LIMIT;
import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_UPPER_LIMIT;

public class LottoNumberValidator {
    public static void validateLottoNumbers(Set<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateLottoNumberRange(lottoNumber);
        }
    }

    public static void validateLottoNumberRange(Integer lottoNumber) {
        if (lottoNumber == null || lottoNumber < LOTTO_NUMBER_LOWER_LIMIT || lottoNumber > LOTTO_NUMBER_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format("로또번호는 %d~%d 사이의 숫자만 가능합니다", LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT));
        }
    }
}
