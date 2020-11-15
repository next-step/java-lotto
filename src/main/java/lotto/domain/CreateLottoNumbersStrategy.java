package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<LottoNumber> create();
}
