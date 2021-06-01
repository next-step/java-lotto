package lotto.domain.generator;

import lotto.domain.config.NumberSize;
import lotto.domain.entity.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AutomaticLottoNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public List<Number> generateNumber() {
        List<Number> numbers = new ArrayList<>();
        for (int i = NumberSize.NUMBER_MIN; i <= NumberSize.NUMBER_MAX; i++) {
            numbers.add(Number.of(i));
        }
        Collections.shuffle(numbers);
        List<Number> automaticNumbers = numbers.subList(0, NumberSize.FULL_NUMBER_SIZE);
        sortNumbers(automaticNumbers);
        return automaticNumbers;
    }

    @Override
    public void sortNumbers(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
