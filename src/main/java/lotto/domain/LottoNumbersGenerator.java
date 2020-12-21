package lotto.domain;

import java.util.Set;

public interface LottoNumbersGenerator {
    Set<LottoNumber> generate();
}
