package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
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

        Lotto winLotto = new Lotto(InputView.inputWinNumber());
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = lottoMachine.result(winLotto, bonusBall);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(money));
    }
}
