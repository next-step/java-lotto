package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private final List<Integer> numbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public List<Integer> getNumber() {
        Collections.shuffle(this.numbers);
        return this.numbers.subList(0, 6);
    }
}
