package lotto.domain;

import java.util.Set;

@FunctionalInterface
public interface LottoMachine {

    Set<Integer> createLottoNumber(int capacity);
}
