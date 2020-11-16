package step4.strategy;

import step4.lotto.firstcollection.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface NumberMakeStrategy {
    Set<LottoNumber> create();
}
