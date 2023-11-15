package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStrategy implements GenerateStrategy {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.NUMBER_MIN, LottoNumber.NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

    private static final Random random = new Random();

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(randomNumber);

        return randomNumber.stream()
                .limit(LottoNumbers.NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
