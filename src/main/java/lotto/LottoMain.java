package lotto;

import lotto.domains.Lottos;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            String money = InputView.takeMoney();

            Lottos lottos = new Lottos(money);

            ResultView.printLottoCount(lottos.getLottosCnt());
            ResultView.printLottos(lottos);



        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
