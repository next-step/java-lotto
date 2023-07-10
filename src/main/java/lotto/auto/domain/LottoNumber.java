package lotto.auto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final List<Integer> lottoNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
