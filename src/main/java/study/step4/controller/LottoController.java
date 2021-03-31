package study.step4.controller;

import java.util.List;

import study.step4.domain.LottoMoney;
import study.step4.domain.LottoTicketCount;
import study.step4.domain.Lotto;
import study.step4.domain.LottoFactory;
import study.step4.domain.LottoNumber;
import study.step4.domain.LottoWin;
import study.step4.domain.Lottos;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class LottoController {
    public LottoController() {
    }

    public void play() {
        LottoMoney money = new LottoMoney(InputView.inputPurchaseAmount());
        LottoTicketCount manualCount = new LottoTicketCount(InputView.inputManualCount());
        LottoTicketCount autoCount = new LottoTicketCount(money.buyableCount(manualCount));

        List<String> manualNumbers = InputView.inputManualNumber(manualCount);
        Lottos lottos = LottoFactory.buy(autoCount, manualNumbers);

        ResultView.printPurchaseLottoCount(manualCount, autoCount);
        ResultView.printLottoNumbers(lottos);

        Lotto lotto = new Lotto(InputView.inputWinNumber());
        LottoNumber bonusBall = LottoNumber.of(InputView.inputBonusBall());
        LottoWin lottoWin = lottos.result(lotto, bonusBall);

        ResultView.printResult(lottoWin);
        ResultView.printProfit(lottoWin.profit(money));
    }
}
