package step2.ui;

import step2.LottoNumber;
import step2.LottoNumbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumbers {
    private static final String SPLITTER = ", ";
    private List<LottoNumber> numbers;

    public InputNumbers(String text) {
        List<LottoNumber> numbers = Arrays.asList(text.split(SPLITTER))
                .stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return new LottoNumbers(numbers);
    }

}

