package step3.strategy;

import step3.domain.lotto.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface NumberMakeStrategy {
    Set<LottoNumber> create();
}
