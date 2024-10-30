package lotto.random;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<LottoNumber> executeStrategy();
}
