package step5.ui;


import step5.domain.Lotto;
import step5.domain.LottoNumber;
import step5.domain.Rank;
import step5.domain.Ranks;

import java.util.List;

public class ResultView {

    public static void showAutoLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + " 개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); ++i) {
            showLotto(lottos.get(i));
        }
    }

    public static void showLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void showStatistics(Ranks ranks) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원) -" + ranks.findCountWithAmount(Rank.FIFTH.getWinningMoney()) + "개");
        System.out.println("4개 일치 (50000원) -" + ranks.findCountWithAmount(Rank.FOURTH.getWinningMoney()) + "개");
        System.out.println("5개 일치 (1500000원) -" + ranks.findCountWithAmount(Rank.THIRD.getWinningMoney()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) -" + ranks.findCountWithAmount(Rank.SECOND.getWinningMoney()) + "개");
        System.out.println("6개 일치 (2000000000원) -" + ranks.findCountWithAmount(Rank.FIRST.getWinningMoney()) + "개");

    }

    public static void showRate(Ranks ranks) {
        System.out.println("총 수익률은 " + ranks.earningRate() + " 입니다.");
    }
}
