package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.io.InputView;
import lotto.util.DivideUtil;

import static lotto.io.InputView.*;
import static lotto.io.OutputView.*;

public class LottoGame {

    public static void main(String[] args) {
        LottoMoney money = InputView.requestPurchaseAmount();
        Lottos lottos = new Lottos(money.getLottoTicketCount());
        Lotto winningLotto = requestWinningLotto();

        lottos.updateLottoResult(winningLotto);
        long totalMoney = LottoPrize.getTotalPrize();
        printProfitRate(DivideUtil.divide(totalMoney, money.getValue()));
    }


}
