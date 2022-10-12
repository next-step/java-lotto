package lotto.application;

import lotto.domain.LottoPrice;

public class Main {

    public static void main(String[] args) {
        new LottoGame(new InputView(), new OutputView(new LottoPrice())).play();
    }
}
