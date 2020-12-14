package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 45;

    private List<Number> numbers;

    public LottoNumberGenerator() {
        this.numbers = new ArrayList<>();
        for (int i=START_NUMBER; i<=END_NUMBER; i++) numbers.add(new Number(i));
    }

    public Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(
                numbers.stream()
                        .limit(6)
                        .sorted(Comparator.comparing(Number::getNumber))
                        .collect(Collectors.toList()));
    }
}
