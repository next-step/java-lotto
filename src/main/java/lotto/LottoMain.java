package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        Money money = new Money(InputView.getInputMoney());

        LottoGroup lottoGroup = new LottoGroup(money);

        ResultView.showBuyLottos(lottoGroup);

        Lotto winLotto = new Lotto(InputView.getInputWinNumber());

        LottoNumber bonusNumber = new LottoNumber(InputView.getInputBonusNumber());

        LottoResult result = lottoGroup.match(winLotto, bonusNumber);

        ResultView.showStatus(result, money);
    }
}
