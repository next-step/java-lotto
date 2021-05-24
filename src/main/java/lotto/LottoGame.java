package lotto;

import lotto.lotto.LottoNumber;
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
        OutputView.printLottoAmount(lottoTicket.matchingCount());
        OutputView.printLottoTicket(lottoTicket);
        OutputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber());
        LottoNumber bonusNumber = new LottoNumber(5);
        LottoResult lottoResult = shop.lottoResult(lottoTicket, winningNumber, bonusNumber);
        OutputView.resultMessage();
        OutputView.resultIncome(lottoResult, money);
    }
}