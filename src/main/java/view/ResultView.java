package view;

import domain.Lotto;

import java.util.List;

public class ResultView {

    public static void boughtLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()+"개를 구매했습니다.\n");
        for (Lotto lotto: lottos) {
            sb.append(lotto.toString()+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void showLottoStatistics() {

    }
}
