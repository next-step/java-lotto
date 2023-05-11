package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getPurchaseMoney();
        int manualLottoCount = InputView.getManualLottoCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount);
        Lottos manualLottos = LottosFactory.createManualByStringList(manualLottoNumbers);
        CombinedLottos combinedLottos = LottoShop.sell(money, manualLottos);
        ResultView.showCombinedLottos(combinedLottos);

        Lotto lastWinningLotto = Lotto.from(InputView.getLastWinningLotto());
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        WinningLotto winningLotto = new WinningLotto(lastWinningLotto, bonusNumber);
        LottoResult lottoResult = new LottoResult(combinedLottos.getCombinedLottos(), winningLotto);
        ResultView.showResult(lottoResult);
    }
}
