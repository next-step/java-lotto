package step2.view;

import step2.domain.Lotto;
import step2.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RenderView {

    public static void showLottoList(List<Lotto> purchasedLottoList) {
        StringBuilder sb = new StringBuilder(purchasedLottoList.size() + "개를 구매했습니다.\n");

        for (Lotto lotto : purchasedLottoList) {

            String lottoNumbers = lotto.strem()
                    .map((lottoNumber) -> String.valueOf(lottoNumber.getLottoNumber()))
                    .collect(Collectors.joining(","));

            sb.append("[" + lottoNumbers + "]");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void showWinningStatic(Map<Rank, Integer> rankInfo) {
        StringBuilder sb = new StringBuilder("당첨 통계\n");
        sb.append("-------\n");
        sb.append("3개 일치 (5000원) -" + rankInfo.get(Rank.FOURTH) + "개\n");
        sb.append("4개 일치 (50000원) -" + rankInfo.get(Rank.THIRD) + "개\n");
        sb.append("5개 일치 (1500000원) -" + rankInfo.get(Rank.SECOND) + "개\n");
        sb.append("6개 일치 (2000000000원) -" + rankInfo.get(Rank.FIRST) + "개\n");

        System.out.println(sb.toString());
    }

    public static void showTotalYield(double totalYield) {
        StringBuilder sb = new StringBuilder("총 수익률은" + totalYield + "입니다.");

        System.out.println(sb.toString());
    }
}
