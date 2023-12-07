package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyInfo;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;

public class LottoService {

    public static Lottos purchaseLotto(LottoBuyInfo buyInfo) {
        Lottos manualLottos = Lottos.from(LottoInputView.inputManualLottoNumbers(buyInfo.getManualCount()));
        Lottos autoLottos = Lottos.from(buyInfo.getAutoCount());

        return Lottos.of(manualLottos, autoLottos);
    }

    public static WinningLotto winningLotto() {
        Lotto winningLotto = Lotto.from(LottoInputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.from(LottoInputView.inputBonusNumber());
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
