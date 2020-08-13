package domain;

import strategy.RandomNumberGenerator;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(RandomNumberGenerator randomNumberGenerator) {
        numbers = randomNumberGenerator.generator();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
