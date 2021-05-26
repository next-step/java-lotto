package lotto.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import calculator.StringCalculator;
import lotto.LottoNumbers;

public class MessageLottoNumberGenerator implements Generator {

    private final List<Integer> numbers;

    public MessageLottoNumberGenerator(String message) {
        List<String> numbers = Arrays.asList(StringCalculator.tokenizing(message, ", "));
        this.numbers = numbers.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public LottoNumbers generate() {
        Collections.sort(numbers);
        return new LottoNumbers(numbers);
    }

}
