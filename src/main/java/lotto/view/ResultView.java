package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

}
