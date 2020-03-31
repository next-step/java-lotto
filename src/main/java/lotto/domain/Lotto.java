package lotto.domain;

import lombok.Getter;
import lotto.exception.LottoException;
import lotto.type.ExceptionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final String REGEX = ",";

    @Getter
    private List<Integer> numbers;

    public Lotto(String lottoValue) {
        this(Arrays.stream(lottoValue.split(REGEX))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList()));
    }

    Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new LottoException(ExceptionType.INVALID_LOTTO_NUMBER);
        }

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
