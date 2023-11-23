package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> lotto;
    private final List<Integer> lottoNumberSet = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    public Lotto() {
        lotto = makeLotto();
    }

    private List<Integer> makeLotto() {
        Collections.shuffle(lottoNumberSet);
        return lottoNumberSet.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> lotto() {
        return lotto;
    }
}
