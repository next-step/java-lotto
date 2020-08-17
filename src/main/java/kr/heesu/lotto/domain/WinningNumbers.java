package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.List;

public class WinningNumbers {
    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    private WinningNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers of(List<LottoNumber> numbers) {
        validationCheck(numbers);
        return new WinningNumbers(numbers);
    }

    private static void validationCheck(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_WINNING_NUMBERS.getMessage());
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return this.numbers;
    }
}

