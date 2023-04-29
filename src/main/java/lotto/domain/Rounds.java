package lotto.domain;

import lotto.strategy.LottoStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constants.ZERO;

public class Rounds {

    private final List<Lotto> lottoList;

    public Rounds(LottoStrategy lottoStrategy, int count) {
        lottoList = createLotto(lottoStrategy, count);
    }

    private List<Lotto> createLotto(LottoStrategy lottoStrategy, int count) {
        return IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(lottoStrategy.generateNumbers()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
