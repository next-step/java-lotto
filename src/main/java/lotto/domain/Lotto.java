package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.LottoMachine;
import lotto.RandomUtils;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = generateRandomNumbers();
        shuffle();
        sort();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < LottoMachine.LOTTO_SIZE; i++) {
            numbers.add(RandomUtils.nextInt());
        }

        return numbers;
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public void sort() {
        Collections.sort(numbers);
    }
}
