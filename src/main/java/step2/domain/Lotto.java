package step2.domain;

import step2.domain.starategy.GetLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public static final int SIZE = 6;

    public static List<Integer> NumberList = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public Lotto(GetLottoNumberStrategy getLottoNumberStrategy) {
        this.lottoNumbers = getLottoNumberStrategy.getLotto();

    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Integer checkMatching(List<Integer> winningNumbers) {
        Long count = lottoNumbers.stream().filter(i->winningNumbers.contains(i)).count();
        return count.intValue();
    }
}
