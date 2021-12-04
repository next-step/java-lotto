package step2;

import step2.controller.LottoController;
import step2.domain.Lotto;

public class Runner {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        Lotto lotto = lottoController.buyAndPrintLotto();
        lottoController.winningInformationOf(lotto);
    }

}
