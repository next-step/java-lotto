package lotto;

import lotto.domain.lotto.LottoPackage;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.MatchResult;
import lotto.domain.money.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        LottoPackage lottoPackage = purchaseLotto();
        calculateWinningStatistics(lottoPackage);
    }

    private static LottoPackage purchaseLotto() {
        Money money = InputView.inputPurchaseMoney();
        LottoPackage lottoPackage = LottoService.purchase(money);
        ResultView.printLottos(lottoPackage);
        return lottoPackage;
    }

    private static void calculateWinningStatistics(LottoPackage lottoPackage) {
        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = LottoService.match(lottoPackage, winningLotto);
        ResultView.printMatchResult(matchResult);
    }

}