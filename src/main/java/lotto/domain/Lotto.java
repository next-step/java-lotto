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

    public Rank match(Numbers winnerNumbers, Numbers bonusNumbers) {
        int matchCount = this.numbers.match(winnerNumbers);
        boolean bonusMatch = this.numbers.match(winnerNumbers, bonusNumbers);

        return Rank.find(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
