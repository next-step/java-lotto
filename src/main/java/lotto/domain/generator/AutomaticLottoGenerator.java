package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AutomaticLottoGenerator implements LottoGenerator {

    @Override
    public List<Number> numberGenerator() {
        List<Number> numbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(new Number(i));
        }
        Collections.shuffle(numbers);
        List<Number> automaticNumbers = numbers.subList(0, LOTTO_FULL_NUMBER);
        sortNumbers(automaticNumbers);
        return automaticNumbers;
    }

    @Override
    public void sortNumbers(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }


}
