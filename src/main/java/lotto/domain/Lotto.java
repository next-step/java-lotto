package lotto.domain;

import lombok.Getter;
import lotto.exception.LottoException;
import lotto.exception.ExceptionType;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String REGEX = ",";

    @Getter
    private List<Integer> numbers;

    public Lotto(String lottoValue) {
        this(Arrays.stream(lottoValue.split(REGEX))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList()));
    }

    Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;

        validNumbers();
    }

    public int getMatchCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(number -> lotto.contains(number))
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validNumbers() {
        if (numbers.size() != LOTTO_COUNT) {
            throw new LottoException(ExceptionType.INVALID_LOTTO_NUMBER_SIZE);
        }

        if(new HashSet<>(numbers).size() < LOTTO_COUNT) {
            throw new LottoException(ExceptionType.DUPLICATED_LOTTO_NUMBER);
        }

        if(invalidNumber()) {
            throw new LottoException(ExceptionType.INVALID_LOTTO_NUMBER);
        }
    }

    private boolean invalidNumber() {
        return numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }
}
