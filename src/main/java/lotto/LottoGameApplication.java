package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.ManualNumber;
import lotto.domain.Money;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameApplication {

  public static void main(String[] args) {
    Money money = Money.from(InputView.amount());
    ManualNumber manualNumber = new ManualNumber(InputView.numberOfManual());
    money = money.manual(manualNumber.number());

    LottoTicket lottoTicket = new LottoTicket(
        LottoFactory.lotto(money.countLotto(),
            InputView.manualLottoNumbers(manualNumber.number())));
    ResultView.print(money.countLotto(), manualNumber.number());
    ResultView.print(lottoTicket);

    LottoResult lottoResult = LottoGame.match(lottoTicket, new WinLotto(
        LottoFactory.lotto(InputView.winLottoNumber()),
        LottoNumber.from(InputView.bonusNumber())));
    ResultView.print(lottoResult, money);
  }
}
