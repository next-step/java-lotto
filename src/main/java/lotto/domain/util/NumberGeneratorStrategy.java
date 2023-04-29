package lotto.domain.util;

import lotto.domain.LottoNumbers;

@FunctionalInterface
public interface NumberGeneratorStrategy {

    LottoNumbers generate();

}