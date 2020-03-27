package lotto.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    @Getter
    private List<Integer> numbers;

    public Lotto(String lottoValue) {
        this(Arrays.stream(lottoValue.split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList()));
    }

    Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new RuntimeException("Lotto number must be 6");
        }

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public int getSameCount(Lotto lotto) {
        int sameCount = 0;

        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
