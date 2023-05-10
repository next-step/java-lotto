package lotto.domain.generator;

import lotto.domain.number.LottoNumber;

import java.util.HashSet;

public interface LottoGenerator {

    HashSet<LottoNumber> generate();
}
