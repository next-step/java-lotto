package lotto.model;

import java.util.Set;

@FunctionalInterface
public interface LottoGenerator {
    Set<LottoNumber> get();
}
