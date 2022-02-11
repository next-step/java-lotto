package lotto;

import lotto.controller.LottoAuto;

public class Application {

    public static void main(String[] args) {
        LottoAuto lottoAuto = LottoAuto.getInstance();
        lottoAuto.play();
    }
}
