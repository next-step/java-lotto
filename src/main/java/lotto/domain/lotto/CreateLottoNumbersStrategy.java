package lotto.domain.lotto;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<LottoNumber> create(LottoNumber bonusNumber);
}
