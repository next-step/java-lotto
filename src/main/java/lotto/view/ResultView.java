package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyingLottos(Lottos lottos) {
        System.out.println(lottos.getCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getLottoNumberString());
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> totalBuyingLottoRank, int totalWinningMoney, int paying) {
        System.out.println("당첨 통계");
        System.out.println("---------------------------------");
        System.out.println("3개 일치 (5000원)-" + totalBuyingLottoRank.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)-" + totalBuyingLottoRank.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)-" + totalBuyingLottoRank.get(Rank.THIRD) + "개");
        System.out.println("5개 일치 + 보너스볼 일치 (3000000원)-" + totalBuyingLottoRank.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)-" + totalBuyingLottoRank.get(Rank.FIRST) + "개");

        double rateOfReturn = totalWinningMoney / (double) paying;

        System.out.printf("%.2f%n", rateOfReturn);
    }
}

