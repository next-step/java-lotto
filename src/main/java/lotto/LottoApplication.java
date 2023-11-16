package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.LottoStatsResponse;
import lotto.ui.dto.MyLottosResponse;

public class LottoApplication {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);

        OutputView.outputPurchaseCount(money.purchaseCount());

        MyLottos myLottos = LottoFactory.buy(money);
        OutputView.outputMyLottos(MyLottosResponse.from(myLottos));

        WinningLotto winningLotto = new WinningLotto(InputView.winningNumbers());
        LottoResult lottoResult = myLottos.getLottoResult(winningLotto);

        OutputView.outputLottoStats(LottoStatsResponse.from(lottoResult, money));
    }

}
