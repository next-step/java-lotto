package lotto.domain.lotto.strategy;

import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements GenerateStrategy {

    private static final Random random = new Random();

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < LottoConstants.NUMBER_COUNT; i++) {
            numbers.add(randomNumber());
        }

        return numbers;
    }

    private static Integer randomNumber() {
        return random.nextInt(LottoConstants.NUMBER_MAX) + LottoConstants.NUMBER_MIN;
    }
}
