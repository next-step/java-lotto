package step3.domain.strategy.lotto;

import step3.domain.model.Lotto.LottoNumbers;

import java.util.List;

public interface PolicyStrategy {
    LottoNumbers createLottoNumbers();

    LottoNumbers createWinningLottoNumber(String lastWinningNumbers);
    LottoNumbers createManualLottoNumbers(List<Integer> manualLottoNumbers);
}
