package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int buyLottoMoney = InputView.buyLotto();
        Money money = new Money(buyLottoMoney);

        Lotto lotto = new Lotto(money.countLotto());
        lotto.drawingLotto();
        ResultView.printLottoNumbers(lotto);

        String[] winningNumbers = InputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
    }
}
