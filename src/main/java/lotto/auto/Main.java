package lotto.auto;

import lotto.auto.domain.Lotto;
import lotto.auto.domain.LottoHandler;
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
        int lottoCount = lottoHandler.buyLotto(money);
        outputView.printPurchase(lottoCount);
        List<Lotto> lottos = lottoHandler.createLotto(lottoCount);
        for (Lotto lotto : lottos) {
            outputView.print(lotto.toString());
        }
        WinNumber winNumber = inputView.requestWinNumber();
        List<Win> wins = lottoHandler.confirmWinner(lottos, winNumber);

        outputView.printWinResult(money, wins);
    }


}
