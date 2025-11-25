package lotto;

import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getInputMoney();

        LottoGroup lottoGroup = new LottoGroup(money);

        ResultView.showBuyLottos(lottoGroup);

        ResultView.showStatus(new LottoResult(lottoGroup, InputView.getInputWinNumber()), money);
    }
}
