package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public void start() {
        InputView inputView = new InputView();
        int money = inputView.inputMoneyPrint();

        int manualLottoNo = inputView.inputBuyLotto();
        List<Lotto> manualLottoNumbers = inputView.inputBuyLottoNumbers(manualLottoNo);

        ResultView resultView = new ResultView();
        resultView.buyLottoAndNumbersPrint(money, manualLottoNumbers.size());

        List<Integer> inputNumbers = inputView.inputLottoNumbers();
        int inputBonusNo = inputView.inputLottoBonusNumber();
        resultView.resultPrint(inputNumbers, inputBonusNo, money, manualLottoNumbers);
    }

//    public static Rank matchOfRank(Lotto lotto, WinningLotto winningLotto) {
//        return winningLotto.match(lotto);
//    }
}
