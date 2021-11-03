package lotto.views;

import lotto.domains.Lotto;
import lotto.domains.Lottos;

public class ResultView {

    public static void printLottoCount(int lottosCnt) {
        StringBuilder sb = new StringBuilder(lottosCnt);
        sb.append(" 개를 구매했습니다.");

        System.out.println(sb.toString());
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

}
