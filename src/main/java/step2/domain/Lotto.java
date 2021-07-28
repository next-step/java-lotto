package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> lottoNums;
    private static final List<Integer> lottoRange = Stream.iterate(1, n -> n + 1).limit(46).collect(Collectors.toList());

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public static Lotto createLotto() {
        Collections.shuffle(lottoRange);
        return new Lotto(lottoRange.stream().limit(6).collect(Collectors.toList()));
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }
}
