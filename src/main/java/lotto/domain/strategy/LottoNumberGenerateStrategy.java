package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoNumberGenerateStrategy {
    Set<LottoNumber> generateLottoNumbers();
}
