package step3.ui;

import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Rank;
import step3.domain.Ranks;

import java.util.List;

public class ResultView {

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + " 개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); ++i) {
            showLotto(lottos.get(i));
        }
    }

    public static void showLotto(Lotto lotto) {
        List<LottoNumber> copy = lotto.shuffledLottoList();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : copy) {
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
