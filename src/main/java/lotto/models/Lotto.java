package lotto.models;

import lotto.validator.LottoValidator;

import java.util.*;

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
}
