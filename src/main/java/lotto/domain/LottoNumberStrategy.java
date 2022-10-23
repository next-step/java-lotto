package lotto.domain;

import java.util.Set;

public interface LottoNumberStrategy {
    Set<Number> provideNumberSet();
}
