package step2.strategy;

import step2.domain.lotto.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface NumberMakeStrategy {
    Set<LottoNumber> create();
}
