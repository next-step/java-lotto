package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoShop;
import lotto.domain.Order;
import lotto.io.InputView;
import lotto.io.OutputView;

public class Main {

    public static void main(String[] args) {

        Order order = InputView.getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

        OutputView.showLottoCount(order);

        lottoBundle.collectNumbersAsString().forEach(OutputView::showLottoNumber);



    }
}
