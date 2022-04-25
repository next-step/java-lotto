package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public static void outputLottoNumbers(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.length());
        System.out.println(lottos);
        System.out.println();
    }

}
