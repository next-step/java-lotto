package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Numbers;

public class AutoGenerator implements LottoGenerator {

    private List<Integer> numberPool = new ArrayList<>();

    public AutoGenerator() {
        generate();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(numberPool);
    }

    private void generate() {
        numberPool = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public Numbers generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS; i++) {
            numbers.add(numberPool.get(i));
        }

        return new Numbers(
            numbers.stream()
            .sorted()
            .collect(Collectors.toList())
        );
    }
}
