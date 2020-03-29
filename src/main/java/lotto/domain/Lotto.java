package lotto.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final String REGEX = ",";
    private static final int ADD_COUNT = 1;
    private static final int ZERO = 0;

    @Getter
    private List<Integer> numbers;

    public Lotto(String lottoValue) {
        this(Arrays.stream(lottoValue.split(REGEX))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList()));
    }

    Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new RuntimeException("Lotto number must be 6");
        }

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public int getSameCount(Lotto lotto) {
        int sameCount = 0;

        for (Integer number : numbers) {
            sameCount += getAddCount(lotto, number);
        }

        return sameCount;
    }

    private int getAddCount (Lotto lotto, int number) {
        if (lotto.contains(number)) {
            return ADD_COUNT;
        }

        return ZERO;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
