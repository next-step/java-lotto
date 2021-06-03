package lotto.domain.generator;

import lotto.domain.entity.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumbersGenerator {

    @Override
    public List<Number> generateNumber() {
        throw new RuntimeException("입력 값이 필요합니다.");
    }

    public List<Number> generateNumber(String text) {
        List<String> texts = Arrays.asList(text.split(","));
        List<Number> numbers = new ArrayList<>();
        texts.forEach(number -> {
            numbers.add(Number.of(number));
        });
        sortNumbers(numbers);
        return numbers;
    }

    @Override
    public void sortNumbers(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
