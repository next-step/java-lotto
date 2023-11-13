package lotto.domain.lotto.strategy;

import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomStrategy implements GenerateStrategy {

    private static final Random random = new Random();

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(LottoConstants.LOTTO_NUMBERS);
        Collections.shuffle(randomNumber);

        return randomNumber.stream()
                .limit(LottoConstants.NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
