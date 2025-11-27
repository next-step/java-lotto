package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        Money money = new Money(InputView.getInputMoney());

        LottoGroup lottoGroup = new LottoGroup(money);

        ResultView.showBuyLottos(lottoGroup);

        Lotto winLotto = new Lotto(InputView.getInputWinNumber());

        LottoResult result = lottoGroup.match(winLotto);

        ResultView.showStatus(result, money);
    }
}
