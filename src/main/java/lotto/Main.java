package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoShop;
import lotto.domain.Order;
import lotto.io.InputView;

public class Main {

    public static void main(String[] args) {

        Order order = InputView.getOrder();

        LottoBundle lottoBundle = LottoShop.order(order);

    }
}
