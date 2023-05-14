package lotto.domain.generator;

import lotto.domain.number.LottoNumber;

import java.util.Set;

public interface LottoGenerator {

    Set<LottoNumber> generate();
}
