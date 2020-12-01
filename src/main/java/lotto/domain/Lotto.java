package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < LottoMachine.LOTTO_SIZE) {
            numbers.add(RandomUtils.nextInt());
        }

        return new ArrayList<>(numbers);
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public void sort() {
        Collections.sort(numbers);
    }
}
