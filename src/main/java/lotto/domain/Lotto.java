package lotto.domain;

import java.util.Set;
import java.util.TreeSet;

import lotto.LottoMachine;
import lotto.RandomUtils;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = generateRandomNumbers();
    }

    public Set<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new TreeSet<>();

        while (numbers.size() < LottoMachine.LOTTO_SIZE) {
            numbers.add(RandomUtils.nextInt());
        }

        return numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
