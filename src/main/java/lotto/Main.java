package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoShop;
import lotto.domain.Order;

import static lotto.io.InputView.getOrder;
import static lotto.io.OutputView.showLottoCount;
import static lotto.io.OutputView.showLottoNumber;

public class Main {

    public static void main(String[] args) {

        Order order = getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

        showLottoCount(order);

        showLottoNumber(lottoBundle.collectNumbersAsString());

    }
}
