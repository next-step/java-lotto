package lotto.domain;

import java.util.Set;

public interface LottoMachine {

    Set<Integer> createLottoNumber(int capacity);
}
