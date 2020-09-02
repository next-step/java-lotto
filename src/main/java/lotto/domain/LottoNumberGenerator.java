package lotto.domain;

import java.util.Set;

@FunctionalInterface
public interface LottoNumberGenerator {

    Set<LottoNumber> generator(int count);
}
