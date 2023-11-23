package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRandomNumberStrategy implements RandomNumberStrategy {

    private static final int REQUIRED_RANDOM_NUMBERS_SIZE = 6;

    @Override
    public List<Integer> getRandomNumbers(List<Integer> numbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < REQUIRED_RANDOM_NUMBERS_SIZE; i++) {
            randomNumbers.add(numbers.get(i));
        }
        return randomNumbers;
    }
}
