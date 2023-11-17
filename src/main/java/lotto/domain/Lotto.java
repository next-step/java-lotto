package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> lottos;

    public Lotto() {
        this.lottos = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lottos;
    }
}
