package lotto.domain;

import lotto.util.RandomUtil;

import java.util.List;

public class Lotto {

    private static final int DEFAULT_LOTTO_SIZE = 6;
    private final Numbers numbers;

    public Lotto() {
        List<Integer> randomDatas = RandomUtil.getRandomInteger(DEFAULT_LOTTO_SIZE);
        numbers = Numbers.createNumbers(randomDatas);
    }

    public Numbers find() {
        return this.numbers;
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
