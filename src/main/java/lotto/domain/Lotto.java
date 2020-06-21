package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {


        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != LOTTO_SIZE;
    }

}
