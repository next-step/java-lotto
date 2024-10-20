package lotto.domain;

import java.util.Set;

import static lotto.domain.LottoNumberGenerator.*;

public class LottoNumberValidator {
    public static void validateLottoNumbers(Set<Integer> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);
        for (Integer lottoNumber : lottoNumbers) {
            validateLottoNumberRange(lottoNumber);
        }
    }

    private static void validateLottoNumberSize(Set<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("로또번호는 %d개 이어야 합니다", LOTTO_NUMBERS_SIZE));
        }
    }

    public static void validateLottoNumberRange(Integer lottoNumber) {
        if (lottoNumber == null || lottoNumber < LOTTO_NUMBER_LOWER_LIMIT || lottoNumber > LOTTO_NUMBER_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format("로또번호는 %d~%d 사이의 숫자만 가능합니다", LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT));
        }
    }
}
