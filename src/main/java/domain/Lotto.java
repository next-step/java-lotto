package domain;

import strategy.NumberGenerator;
import strategy.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(NumberGenerator randomNumberGenerator) {
        List<Integer> shuffleNumbers = randomNumberGenerator.generator();
        Collections.sort(shuffleNumbers);

        this.numbers = shuffleNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public int hasWinningNumber(List<Integer> winningNumbers) {
        int hitCount = 0;
        for (Integer winningNumber : winningNumbers) {
            hitCount += numbers.contains(winningNumber) ? 1 : 0;
        }

        return hitCount;
    }
}
