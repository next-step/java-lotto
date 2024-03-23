package lotto.domain.number_generator;

import lotto.domain.Rule;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        return Rule.generateRandomNumbers();
    }

}
