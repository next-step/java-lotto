package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto of(List<LottoNumber> numbers) {
        validationCheck(numbers);
        return new Lotto(numbers);
    }

    private static void validationCheck(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO.getMessage());
        }
    }

    private boolean contain(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public Long match(List<LottoNumber> winningNumbers) {
        return winningNumbers.stream()
                .filter(this::contain)
                .count();
    }

    @Override
    public String toString() {
        return "[" + this.numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}

