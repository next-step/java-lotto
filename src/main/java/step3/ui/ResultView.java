package step3.ui;

import step3.domain.Lotto;
import step3.domain.LottoCount;
import step3.domain.LottoNumber;

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

    public static void showStatistics(LottoCount lottoCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원) -" + lottoCount.getThreeCount() + "개");
        System.out.println("4개 일치 (50000원) -" + lottoCount.getFourCount() + "개");
        System.out.println("5개 일치 (1500000원) -" + lottoCount.getFiveCount() + "개");
        System.out.println("6개 일치 (2000000000원) -" + lottoCount.getSixCount() + "개");

    }

    public static void showRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + " 입니다.");
    }
}
