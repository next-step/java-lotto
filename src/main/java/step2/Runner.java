package step2;

import step2.controller.LottoController;
import step2.domain.Lottos;

public class Runner {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        Lottos lottos = lottoController.buyAndPrintLotto();
        lottoController.winningInformationOf(lottos);
    }

}
