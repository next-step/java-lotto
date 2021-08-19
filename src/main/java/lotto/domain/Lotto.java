package lotto.domain;

public class Lotto {

    private static final int DEFAULT_LOTTO_SIZE = 6;
    private final Numbers numbers;

    public Lotto() {
        numbers = Numbers.createRandomNumbers();
    }

    public boolean isCreate() {
        return numbers.size() == DEFAULT_LOTTO_SIZE;
    }

    public int match(Numbers winnerNumbers) {
        return this.numbers.match(winnerNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
