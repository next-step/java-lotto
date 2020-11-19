package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoMachine {

    List<Integer> createLottoNumber();
}
