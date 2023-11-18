package study.step2.domain;

import java.util.HashSet;
import java.util.List;

import study.step2.domain.exception.LottoException;

import static study.step2.domain.LottoGenerator.LOTTO_NUMBERS_SIZE;

public class LottoNumber {

    private final Integer lottoNumber;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    public LottoNumber(Integer number) {
        validate(number);
        this.lottoNumber = number;
    }

    private void validate(Integer number) {
        if (!isValid(number)) {
            throw new LottoException("번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isValid(Integer number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public boolean equals(LottoNumber number) {
        return lottoNumber.equals(number.lottoNumber());
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new LottoException("번호는 6자리 중복되지 않은 값이어야 합니다.");
        }
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers)
            .size() == LOTTO_NUMBERS_SIZE;
    }

    public Integer lottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

}
