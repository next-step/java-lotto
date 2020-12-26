package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public void start() {
        InputView inputView = new InputView();
        int money = inputView.inputMoneyPrint();

        BuyLotto buyLotto = new BuyLotto(money);

        ResultView resultView = new ResultView();
        resultView.buyLottoAndNumbersPrint(buyLotto);

        List<Integer> inputNumbers = inputView.inputLottoNumbers();
        int inputBonusNumber = inputView.inputLottoBonusNumber();
        resultView.resultPrint(inputNumbers, inputBonusNumber, buyLotto);
    }
}
