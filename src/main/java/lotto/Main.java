package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int buyLottoMoney = InputView.buyLotto();
        Money money = new Money(buyLottoMoney);


        Lottos lottos = new Lottos(money.countLotto());
        lottos.drawLotto();
        ResultView.printLottoNumbers(lottos);

        String[] winningNumbers  = InputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        int bonusBall = InputView.inputBonusBall();

        LottoMatcher lottoMatcher = new LottoMatcher(lottos.getLottos(), winningNumber.getWinningNumbers());

        ResultView.printResult(lottoMatcher, buyLottoMoney);
    }
}
