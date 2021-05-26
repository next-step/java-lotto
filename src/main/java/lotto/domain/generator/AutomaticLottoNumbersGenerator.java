package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AutomaticLottoNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public List<Number> numberGenerator() {
        List<Number> numbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(new Number(i));
        }
        Collections.shuffle(numbers);
        List<Number> automaticNumbers = numbers.subList(0, FULL_NUMBER_SIZE);
        sortNumbers(automaticNumbers);
        return automaticNumbers;
    }

    @Override
    public void sortNumbers(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }


}
