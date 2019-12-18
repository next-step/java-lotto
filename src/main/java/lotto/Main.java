package lotto;

import lotto.domain.LottoShop;

import static lotto.io.InputView.getOrder;

public class Main {

    public static void main(String[] args) {


        LottoShop.order(getOrder());
    }
}
