package lotto;

import lotto.domain.Purchase;
import lotto.domain.RankLotto;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerResult;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import lotto.view.InputView;

import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        NumberStrategy numberStrategy = new RandomNumberStrategy();
        Purchase purchase = new Purchase(money, numberStrategy);
        System.out.println(purchase.toString());
        String winLottoString = inputView.inputWinNumber();
        WinnerNumber winnerNumber = new WinnerNumber(winLottoString);
        WinnerResult winnerResult = new WinnerResult(winnerNumber.resultLotto(), purchase.lottos());
        System.out.println(winnerResult.toString());
    }
}
