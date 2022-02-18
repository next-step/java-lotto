package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Number;

public class LottoAutoGenerator implements LottoGenerator {

    private List<Integer> numbers;

    public LottoAutoGenerator() {
        generate();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(numbers);
    }

    private void generate() {
        numbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public List<Number> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS; i++) {
            numbers.add(this.numbers.get(i));
        }

        return numbers.stream()
            .sorted()
            .map(Number::new)
            .collect(Collectors.toList());
    }
}
