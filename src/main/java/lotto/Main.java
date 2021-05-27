package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicketCount;
import lotto.domain.LottoWin;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchaseAmount());
        LottoTicketCount manualCount = new LottoTicketCount(InputView.inputManualCount());
        LottoTicketCount autoCount = new LottoTicketCount(money.purchasableCount(manualCount));

        List<String> manualNumbers = InputView.inputManualNumber(manualCount);
        LottoMachine lottoMachine = LottoMachine.of(autoCount, manualNumbers);

        ResultView.printPurchaseCount(autoCount, manualCount);
        ResultView.printLottoNumbers(lottoMachine.lottos());

        Lotto winLotto = new Lotto(InputView.inputWinNumber());
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = lottoMachine.result(winLotto, bonusBall);
        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(money));
    }
}
