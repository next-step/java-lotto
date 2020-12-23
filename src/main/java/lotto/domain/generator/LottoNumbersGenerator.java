package lotto.domain.generator;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoNumbersGenerator {
    Set<LottoNumber> generate();
}
