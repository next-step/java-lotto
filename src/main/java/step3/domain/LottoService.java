package step3.domain;

import step3.domain.model.Lotto.Lotto;
import step3.domain.model.Lotto.LottoNumber;
import step3.domain.model.Lotto.Lottos;
import step3.domain.strategy.lotto.LottoPolicyStrategy;
import step3.param.ManualLottoParam;

import java.util.Objects;

public class LottoService {
    // singleton 적용
    private static LottoService lottoService = null;

    public static LottoService createLottoService() {
        if (Objects.isNull(lottoService)) {
            return new LottoService();
        }
        return lottoService;
    }

    public Lottos createAutoLottos(int count, Lottos manualLotto) {
        Lottos from = Lottos.from(count);
        manualLotto.combineLottos(from);
        return manualLotto;
    }

    public Lottos createManualLotto(ManualLottoParam manualLotto) {
        return Lottos.fromManualLottos(manualLotto);
    }

    public LottoNumber createBonusNumber(int bonusNumber) {
        return LottoNumber.from(bonusNumber);
    }

    public static Lotto createWinningLotto(String lastWinningNumbers) {
        return Lotto.fromWinningLotto(new LottoPolicyStrategy(), lastWinningNumbers);
    }

    public void calculatorWinning(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.calculatorLottoWinning(winningLotto);
        }
    }

    public void calculatorBonusNumber(Lottos lottos, LottoNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.calculatorBonusNumber(bonusNumber);
        }
    }
}
