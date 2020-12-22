package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.requestPurchaseAmount();
        int manualLottoCount = InputView.requestManualLottoCount();
        List<Lotto> manualLottoNumbers = InputView.requestManualLottoNumbers(manualLottoCount);

        LottoShop lottoShop = new LottoShop(money, manualLottoCount);
        Lottos manualLottos = lottoShop.getManualLottos(manualLottoNumbers);
        Lottos autoLottos = lottoShop.getAutoLottos();

        ResultView.showPurchasedLottos(manualLottos, autoLottos);

        Lotto winNumbers = new Lotto(InputView.requestLastWinNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.requestBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);

        Lottos purchasedLottos = autoLottos.conbine(manualLottos);
        WinResult winResults = new WinResult(money, purchasedLottos, winningLotto);

        ResultView.showResults(winResults);
    }
}
