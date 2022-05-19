package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameApplication {

  public static void main(String[] args) {
    Money money = Money.from(InputView.getAmount());
    LottoTicket lottoTicket = LottoFactory.generateAuto(money.countLotto());
    ResultView.print(money.countLotto());
    ResultView.print(lottoTicket);

    LottoResult lottoResult = LottoGame.match(lottoTicket, new WinLotto(
        LottoFactory.generateManual(InputView.getWinNumbers()),
        LottoNumber.from(InputView.getBonusNumber())));
    ResultView.print(lottoResult, money);
  }
}
