package lotto.auto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FullNumber {

    private static List<Integer> fullNumber;

    public FullNumber() {
        fullNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(fullNumber);
    }

    public List<Integer> getFullNumber() {
        return fullNumber;
    }
}
