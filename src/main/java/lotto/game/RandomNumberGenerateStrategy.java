package lotto.game;

import lotto.utils.ShuffleNumbers;

import java.util.List;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {
    @Override
    public List<Integer> generate() {
        return ShuffleNumbers.generateSixNumbers();
    }
}
