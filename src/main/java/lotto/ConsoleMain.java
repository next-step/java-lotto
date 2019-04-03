package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Money money = inputView.printUserInputMoney();

        int quantity = money.purchaseQuantity();

        int manualQuantity = inputView.printManualLottoQuantity(quantity);
        int autoQuantity = quantity - manualQuantity;
        List<String> manualLottos = inputView.inputManualLottoNumbers(manualQuantity);

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.getAllLotto(autoQuantity, manualLottos);

        ResultView resultView = new ResultView();
        resultView.printLottos(lottos, quantity, manualQuantity);

        LottoNumbers luckyNumbers = inputView.lastWeekLuckyNumbers();

        LottoNumber bonusBall = inputView.printInputBonusBall();

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(luckyNumbers, bonusBall);
        LottoResult lottoResult = new LottoResult(lottos, winningLottoNumbers);
        resultView.printLottoResult(lottoResult);
        resultView.printEarningsRate(lottoResult.earningsRate());
    }
}
