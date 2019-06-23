package lotto.utils;

import java.util.List;

public class LottoNumberValidator {

    private static final int MUST_LOTTO_COUNT = 6;

    public static void validate(List<Integer> lottoNumbers) {

        if (lottoNumbers == null || lottoNumbers.size() != MUST_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호 개수는 " + MUST_LOTTO_COUNT + "개 여야 합니다.");
        }
    }
}
