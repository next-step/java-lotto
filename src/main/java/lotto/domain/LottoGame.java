package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public void start() {
        InputView inputView = new InputView();
        int money = inputView.inputMoneyPrint();

        ResultView resultView = new ResultView();
        resultView.buyLottoAndNumbersPrint(money);

        List<Integer> inputNumbers = inputView.inputLottoNumbers();
        int inputBonusNo = inputView.inputLottoBonusNumber();
        resultView.resultPrint(inputNumbers, inputBonusNo, money);
    }

//    public static Rank matchOfRank(Lotto lotto, WinningLotto winningLotto) {
//        return winningLotto.match(lotto);
//    }
}
