package step2;

import step2.controller.LottoMachine;
import step2.domain.Lottos;
import step2.view.ResultView;

public class Main {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        Lottos lottos = LottoMachine.createLottos(3000);
        resultView.showLottos(lottos, 3);
    }
}
