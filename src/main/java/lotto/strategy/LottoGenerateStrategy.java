package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoGenerateStrategy {

    Set<LottoNumber> generateLotto();

}
