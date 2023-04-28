package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoBundle;
import lotto.domain.rating.WinningRatingType;
import lotto.domain.winning.WinningStat;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoCount(LottoBundle lottoBundle) {
        System.out.println("수동으로 " + lottoBundle.getManualCount() + "장, 자동으로 " + lottoBundle.getAutoCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumber(LottoBundle lottoBundle) {
        for (List<Integer> lottoNumber : lottoBundle.getLottoNumbers()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printWinningStat(WinningStat winningStat, Amount amount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + winningStat.getWinningCount(WinningRatingType.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + winningStat.getWinningCount(WinningRatingType.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + winningStat.getWinningCount(WinningRatingType.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + winningStat.getWinningCount(WinningRatingType.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningStat.getWinningCount(WinningRatingType.FIRST) + "개");

        System.out.println("총 수익률은 " + winningStat.rateOfReturn(amount) + "입니다.");
    }
}
