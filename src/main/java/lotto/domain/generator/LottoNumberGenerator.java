package lotto.domain.generator;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoNumberGenerator {
    LottoNumberGenerator DEFAULT_LOTTO_GENERATOR = new LottoNumberRandomGenerator();

    Set<LottoNumber> generate();
}
