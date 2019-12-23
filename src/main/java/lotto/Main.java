package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoShop;
import lotto.domain.Order;

import static lotto.io.InputView.getOrder;
import static lotto.io.OutputView.showOrderStatus;
import static lotto.io.OutputView.showLottoNumbers;

public class Main {

    public static void main(String[] args) {

        Order order = getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

        showOrderStatus(order);

        showLottoNumbers(lottoBundle.collectNumbersAsString());

    }
}
