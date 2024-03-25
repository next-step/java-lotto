package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {

    LottoNumbers generateLottoNumbers(List<Integer> lottoNumberPool);
}

