package lotto.controller;

import lotto.domain.LottoBuy;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void playLotto() {
        Money money = new Money(InputView.getMoney());
        LottoBuy lottoBuy = new LottoBuy(money);
        LottoTicket lottoTicket = lottoBuy.buyAutoLottos(lottoBuy.getCount());

        ResultView.printCount(lottoBuy.getCount());
        ResultView.printLottos(lottoTicket);

        WinningLotto winningLotto = InputView.getLottoWinNumber();
        LottoNumber bonusNumber = InputView.getWinBouns(winningLotto);

        ResultView.printWin(lottoTicket.getMatchWinning(winningLotto, bonusNumber), money);
    }
}
