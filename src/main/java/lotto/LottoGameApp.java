package lotto;

import lotto.controller.LottoGameController;

public class LottoGameApp {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();
    }
}
