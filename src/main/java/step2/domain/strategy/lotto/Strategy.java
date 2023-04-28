package step2.domain.strategy.lotto;

import step2.domain.model.Lotto.LottoNumbers;

public interface Strategy {
    LottoNumbers createLottoNumbers();

    LottoNumbers createWinningLottoNumber(String lastWinningNumbers);
}
