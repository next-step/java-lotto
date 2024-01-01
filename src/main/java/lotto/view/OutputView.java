package lotto.view;

import java.util.List;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {

    public static void numberOfLotto(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void resultStartingPoint() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningLottoCounts(LottoResult result) {
        System.out.println("3개 일치 (" + Rank.findPrizeAmount(Rank.FIFTH) + "원)- " + result.rankCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.findPrizeAmount(Rank.FOURTH) + "원)- " + result.rankCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.findPrizeAmount(Rank.THIRD) + "원)- " + result.rankCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Rank.findPrizeAmount(Rank.SECOND) + "원)- " + result.rankCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.findPrizeAmount(Rank.FIRST) + "원)- " + result.rankCount(Rank.FIRST) + "개");
    }

    public static void rateOfReturn(float rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfReturn) + "입니다.");
    }

    public static void allLottoNumbers(List<LottoNumbers> allLottoNumbers) {
        for (LottoNumbers allLottoNumber : allLottoNumbers) {
            System.out.println(allLottoNumber);
        }
    }

}
