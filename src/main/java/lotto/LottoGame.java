package lotto;

import lotto.lotto.WinningNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.OutputView;
import lotto.ui.InputView;

public class LottoGame {
    public static void start() {
        Shop shop = new Shop();
        OutputView.printInputMoneyMessage();
        Money money = InputView.inputMoneyAmount();
        LottoTicket lottoTicket = shop.buyAutoLotto(money);
        OutputView.printLottoAmount(lottoTicket.count());
        OutputView.printLottoBundle(lottoTicket);
        OutputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
        LottoResult matchAnswer = shop.matchAnswer(lottoTicket, winningNumber);
        OutputView.resultMessage();
        OutputView.resultIncome(matchAnswer, money);
    }
}