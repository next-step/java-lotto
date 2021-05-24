package lotto;

import lotto.lotto.WinningNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.MatchedAnswer;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.OutputView;
import lotto.ui.InputView;
import lotto.ui.Result;

public class LottoGame {
    public static void start() {
        Shop shop = new Shop();
        OutputView.printInputMoneyMessage();
        Money money = InputView.inputMoneyAmount();
        int lottoCount = shop.buyLotto(money);
        OutputView.printLottoAmount(lottoCount);
        LottoTicket lottoTicket = shop.selectAuto(lottoCount);
        OutputView.printLottoBundle(lottoTicket);
        OutputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
        MatchedAnswer matchAnswer = shop.matchAnswer(lottoTicket, winningNumber);
        OutputView.resultMessage();
        Result.resultIncome(matchAnswer, money);
    }
}