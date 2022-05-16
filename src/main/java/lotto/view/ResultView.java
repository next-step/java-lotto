package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyingLottos(Lottos lottos) {
        System.out.println(lottos.getCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getLottoNumberString());
        }
    }

    public static void printWinningStatistics(int[] totalBuyingLottoRank, int totalWinningMoney, int paying) {
        System.out.println("당첨 통계");
        System.out.println("---------------------------------");
        System.out.println("3개 일치 (5000원)-" + totalBuyingLottoRank[3] + "개");
        System.out.println("4개 일치 (50000원)-" + totalBuyingLottoRank[2] + "개");
        System.out.println("5개 일치 (1500000원)-" + totalBuyingLottoRank[1] + "개");
        System.out.println("6개 일치 (2000000000원)-" + totalBuyingLottoRank[0] + "개");

        double rateOfReturn = totalWinningMoney / (double) paying;

        System.out.printf("%.2f%n", rateOfReturn);
    }
}

