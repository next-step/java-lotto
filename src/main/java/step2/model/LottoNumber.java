package step2.model;

import java.util.List;

public class LottoNumber {

    private static final String EXCEPTION_OVER_NUMBER = "총 6개의 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_DUPLICATION_NUMBER = "중복되지 않은 6개의 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_SIX_NUMBER = "숫자의 범위는 1 ~ 45 입니다.";

    private LottoNumber() {};

    public static void validateNumbers(List<Integer> lottoNumbers) {
        checkNumber(lottoNumbers);
        checkSize(lottoNumbers);
        countWithoutDuplication(lottoNumbers);
    }

    private static void checkNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(number -> number > Lotto.MAX || number < Lotto.MIN)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(EXCEPTION_SIX_NUMBER);
                });
    }

    private static void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(EXCEPTION_OVER_NUMBER);
        }
    }

    private static void countWithoutDuplication(List<Integer> lottoNumbers) {
        int cnt = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if (cnt != Lotto.SIZE) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATION_NUMBER);
        }
    }
}
