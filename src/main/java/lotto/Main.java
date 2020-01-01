package lotto;

import lotto.domain.*;

import static lotto.io.InputView.getOrder;
import static lotto.io.InputView.getWinningLotto;
import static lotto.io.OutputView.showLottoNumbers;
import static lotto.io.OutputView.showOrderStatus;

public class Main {

    public static void main(String[] args) {

        Order order = getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

        showOrderStatus(order);

        showLottoNumbers(lottoBundle.collectNumbersAsString());

        WinningLotto winningLotto = getWinningLotto();

        LottoResult lottoResult = new LottoResult();

        lottoResult.match(lottoBundle, winningLotto);


    }
}
