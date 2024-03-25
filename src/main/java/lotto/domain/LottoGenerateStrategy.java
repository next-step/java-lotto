package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generateLottoNumbers(List<Integer> lottoNumberPool);
}

