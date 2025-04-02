package lotto.model.generator;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

import static lotto.model.LottoNumber.LOTTO_MAX_NUMBER;

import java.util.HashSet;
import java.util.Set;
import lotto.model.RequestDto;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public Lotto generate(RequestDto requestDto) {
        Set<Integer> uniqueNumbers = new HashSet<>(requestDto.getUserInputNumbers());

        while (uniqueNumbers.size() < LOTTO_NUMBER_COUNT) {
            int number = numberGenerator.generate(LOTTO_MAX_NUMBER);
            uniqueNumbers.add(number);
        }

        return new Lotto(uniqueNumbers);
    }
}
