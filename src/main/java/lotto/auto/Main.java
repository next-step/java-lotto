package lotto.auto;

import lotto.auto.domain.LottoHandler;
import lotto.auto.domain.LottoPaper;
import lotto.auto.domain.Win;
import lotto.auto.view.InputView;
import lotto.auto.view.OutputView;
import lotto.auto.vo.Money;
import lotto.auto.vo.WinNumber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoHandler lottoHandler = new LottoHandler();

        Money money = new Money(inputView.requestMoney());
        int lottoCount = lottoHandler.countLotto(money);
        LottoPaper lottoPaper = new LottoPaper(lottoCount);
        int manualLottoCount = inputView.requestManualLottoCount();
        lottoPaper = inputView.requestManualLottoNumber(lottoPaper, manualLottoCount);
        lottoHandler.addAutoLottoByCount(lottoPaper, lottoCount - manualLottoCount);
        outputView.printPurchase(manualLottoCount, lottoCount - manualLottoCount);
        outputView.printLottos(lottoPaper);
        WinNumber winNumber = inputView.requestWinNumber();
        winNumber.addBonusNumber(inputView.requestBonusBall());
        List<Win> wins = lottoHandler.confirmWinner(lottoPaper, winNumber);
        outputView.printWinResult(money, wins);
    }


}
