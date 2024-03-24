package lotto.numberdrawer;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumberDrawer {
    List<LottoNumber> drawnNumbers(int bound, int size);
}

