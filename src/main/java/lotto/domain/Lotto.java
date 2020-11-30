package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.LottoMachine;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = Arrays.asList(new Integer[LottoMachine.LOTTO_SIZE]);
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
