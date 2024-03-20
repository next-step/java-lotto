package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> subSet;

    public Lotto() {
        List<Integer> universalSet = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(universalSet);
        this.subSet = universalSet.stream().limit(6).sorted().collect(Collectors.toList());
    }
}
