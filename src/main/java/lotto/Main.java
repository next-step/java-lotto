package lotto;

import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
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

        LottoResult lottoResult = new LottoResult(lottos.getLottos(), winningNumber.getWinningNumbers());
        lottoResult.statistics(buyLottoMoney);

        ResultView.printResult(lottoResult);
    }
}
