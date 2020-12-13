package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private List<Integer> numbers;

    public LottoNumberGenerator() {
        this.numbers = new ArrayList<>();
        for (int i=1; i<=45; i++) numbers.add(i);
    }

    public LottoNumber generate() {
        Collections.shuffle(numbers);
        return new LottoNumber(
                numbers.stream()
                        .limit(6)
                        .sorted()
                        .collect(Collectors.toList()));
    }
}
