package lotto;

import lotto.domain.MyLotto;
import lotto.domain.PrizeResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args){
        int money = InputView.inputPurchaseAmount();

        MyLotto myLotto = new MyLotto(money);
        ResultView.printMyLottoList(myLotto);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        PrizeResult prizeResult = myLotto.getResult(winningNumbers);

        ResultView.printLottoResult(prizeResult);
        ResultView.printEarnRate(prizeResult, money);
    }
}
