package lotto.models;

import lotto.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        Collections.sort(new ArrayList<>(numbers));
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers of(String numbers) {
        List<Integer> splitNumbers = Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        return LottoNumbers.of(splitNumbers);
    }
}
