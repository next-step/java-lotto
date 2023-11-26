package domain;

import generator.LottoNumbersGenerator;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto create(LottoNumbersGenerator generator) {
        return new Lotto(generator.generate());
    }
}
