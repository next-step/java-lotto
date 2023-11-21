package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoGeneration {
    Set<LottoNumber> generate();
}
