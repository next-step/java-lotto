package lotto.domain;

import lotto.util.Request;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public void start() {
        InputView inputView = new InputView();
        int money = inputView.inputMoneyPrint();

        Request request = new Request(money);

        ResultView resultView = new ResultView();
        resultView.buyLottoAndNumbersPrint(request);

        List<Integer> inputNumbers = inputView.inputLottoNumbers();
        resultView.resultPrint(inputNumbers, request);
    }
}
