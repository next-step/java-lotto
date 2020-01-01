package lotto;

import lotto.domain.*;

import static lotto.io.InputView.getOrder;
import static lotto.io.InputView.getWinningLotto;
import static lotto.io.OutputView.*;

public class Main {

    public static void main(String[] args) {

        Order order = getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

        showOrderStatus(order);

        showLottoNumbers(lottoBundle.collectNumbersAsString());

        WinningLotto winningLotto = getWinningLotto();

        LottoResult lottoResult = new LottoResult();

        lottoResult.match(lottoBundle, winningLotto);

        for (Rank rank : Rank.values()) {
            showLottoResult(rank.getMatchCount(), rank.getReward(), lottoResult.getCount(rank));
        }

        showEarningRate((float) lottoResult.getAmount() / (float) order.getPayment());
    }
}
