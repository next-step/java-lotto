package lotto.views;

import lotto.domains.Lottos;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    void printLottos_테스트() {
        Lottos lottos = new Lottos("14000");
        ResultView.printLottos(lottos);
    }
}