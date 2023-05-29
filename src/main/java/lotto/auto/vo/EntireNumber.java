package lotto.auto.vo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntireNumber {
    private static final List<Integer> entireNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Integer> shuffleAndPickNumber() {
        Collections.shuffle(entireNumber);
        return entireNumber.subList(0, 6);
    }
}
