package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        Money money = new Money(InputView.getInputMoney());

        int inputManualLottoCount = InputView.getInputManualLottoCount();

        LottoCount lottoCount = new LottoCount(money, inputManualLottoCount);

        LottoPurChase lottoPurChase = new LottoPurChase(money, lottoCount);

        List<String> manualLottos = InputView.getInputManualLottos(inputManualLottoCount);

        LottoGroup lottoGroup = new LottoGroup(new LottosBundleGenerator(lottoPurChase, manualLottos));

        ResultView.showBuyLottos(lottoGroup, lottoPurChase);

        Lotto winLotto = new Lotto(InputView.getInputWinNumber());

        LottoNumber bonusNumber = LottoNumber.valueOf(InputView.getInputBonusNumber());

        LottoResult result = lottoGroup.match(new LottoWinningNumbers(winLotto, bonusNumber));

        ResultView.showStatus(result, money);
    }
}
