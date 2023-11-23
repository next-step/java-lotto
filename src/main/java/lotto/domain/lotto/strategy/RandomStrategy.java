package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomStrategy implements GenerateStrategy {

    private static final List<Integer> LOTTO_NUMBERS = LottoNumber.newLottoNumbers(Collectors.toList());

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(randomNumber);

        return randomNumber.stream()
                .limit(Lotto.NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
