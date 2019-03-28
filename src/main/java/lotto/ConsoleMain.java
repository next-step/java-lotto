package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Money money = inputView.printUserInputMoney();
        LottoNumber bonusBall = inputView.printInputBonusBall();
        int quantity = money.purchaseQuantity();

        List<Lotto> lottos = LottoMachine.createLotto(quantity);
        ResultView resultView = new ResultView();
        resultView.printLottos(lottos);


        LottoNumbers luckyNumbers = inputView.lastWeekLuckyNumbers();
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers, bonusBall);
        resultView.printLottoResult(lottoResult);
        resultView.printEarningsRate(lottoResult.earningsRate(quantity));
    }
}
