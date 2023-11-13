package lotto.ui;

import lotto.domain.Lottos;

public class OutputView {

    public void printLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottos.getLottos().forEach((key, value) -> System.out.println(value));
    }

}
