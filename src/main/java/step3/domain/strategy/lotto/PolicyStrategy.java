package step3.domain.strategy.lotto;

import step3.domain.model.Lotto.LottoNumbers;

public interface PolicyStrategy {
    LottoNumbers createLottoNumbers();

    LottoNumbers createWinningLottoNumber(String lastWinningNumbers);
}
