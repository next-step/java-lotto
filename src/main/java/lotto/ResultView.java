package lotto;

import java.util.List;

public class ResultView {

    static void showLottoCount(Money money, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 "+ (money.calcLottoCount() - manualLottoCount) + "장을 구매했습니다.");
    }

    static void showLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    static void moveLine() {
        System.out.println();
    }

    static void showStatistics(LottoResultDefault result, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000)원 - " + result.getRankingCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + result.getRankingCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + result.getRankingCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + result.getRankingCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + result.getRankingCount(Rank.FIRST) + "개");

//        for(Rank rank : Rank.values()) {
//            if(rank != Rank.MISS){
//                System.out.println(rank.getCountOfMatch() +"개 일치 (" + rank.getWinningMoney() + ") - " + result.getRankingCount(rank) + "개");
//            }
//        }
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
