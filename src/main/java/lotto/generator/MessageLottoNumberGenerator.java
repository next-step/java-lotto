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

    public static LottoNumbers of(String message) {
        MessageLottoNumberGenerator generator = new MessageLottoNumberGenerator(message);
        return generator.generate();
    }

    @Override
    public LottoNumbers generate() {
        Collections.sort(numbers);
        return new LottoNumbers(numbers);
    }

    protected List<Integer> numbers() {
        return numbers;
    }

}
