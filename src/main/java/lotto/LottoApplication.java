package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    Lotto lotto = LottoStore.buy(Money.wons(InputView.getAmount()));
    ResultView.print(lotto);

    WinLotto winLotto = new WinLotto(LottoFactory.createManual(InputView.getWinNumbers()),
        LottoNumber.from(InputView.getBonusNumber()));
    ResultView.print(lotto.result(winLotto));
  }

}
