package lotto.model.lotto.strategy;

import lotto.model.lotto.LottoNumber;

import java.util.Set;

public interface NumberGenerationStrategy {

    Set<LottoNumber> generateNumbers();

}
