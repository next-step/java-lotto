package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoWin;
import lotto.domain.Money;
import lotto.domain.generator.AutoLottosGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchaseAmount());
        LottoMachine lottoMachine = LottoMachine.of(new AutoLottosGenerator(), money);

        ResultView.printPurchaseCount(money.countOfLotto());
        ResultView.printLottoNumbers(lottoMachine.lottos());

        LottoWin lottoWin = lottoMachine.result(new Lotto(InputView.inputWinNumber()));
        ResultView.printResult(lottoWin);
        ResultView.printProfit(money.money(), lottoWin);
    }
}
