package step4.strategy;

import step4.domain.lotto.firstcollection.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface NumberMakeStrategy {
    Set<LottoNumber> create();
}
