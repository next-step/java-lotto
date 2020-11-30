package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = Arrays.asList(new Integer[LOTTO_SIZE]);
        generateRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomNumbers() {
        Collections.shuffle(numbers);
    }

    public void sort() {
        Collections.sort(numbers);
    }
}
