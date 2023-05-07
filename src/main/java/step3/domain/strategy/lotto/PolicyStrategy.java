package step3.domain.strategy.lotto;

import step3.domain.model.Lotto.LottoNumbers;
import step3.param.ManualLottoNumberParam;

import java.util.List;

public interface PolicyStrategy {
    LottoNumbers createLottoNumbers();

    LottoNumbers createWinningLottoNumber(String lastWinningNumbers);
    LottoNumbers createManualLottoNumbers(List<ManualLottoNumberParam> manualLottoNumbers);
}
