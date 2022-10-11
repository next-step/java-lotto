package lotto.models;

import lotto.validator.LottoValidator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        Collections.sort(new ArrayList<>(numbers));
        return new Lotto(numbers);
    }

    public static Lotto of(String numbers) {
        LottoValidator.validate(numbers);
        List<Integer> splitNumbers = Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        return Lotto.of(splitNumbers);
    }
}
