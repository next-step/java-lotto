package step4.view;

import step4.domain.*;

import java.util.EnumMap;

public class OutputView {

    public static void outputMessageLottoNumbers(LottoGame lottoGame) {
        LottoCount lottoCount = lottoGame.getLottoCount();
        System.out.println("수동으로 "+lottoCount.getManualCount()+"장, 자동으로 "+lottoCount.getAutoCount()+" 구매했습니다.");
        for (Lotto number : lottoGame.getLottos().getLottos()) {
            System.out.println(number);
        }
    }

    public static void outputMessageLottoResult(int amount, LottoResult lottoResult) {
        EnumMap<Rank, Integer> rankMap = lottoResult.winningResult();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)-" + rankMap.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50000원)-" + rankMap.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1500000원)-" + rankMap.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)-" + rankMap.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2000000000원)-" + rankMap.getOrDefault(Rank.FIRST,0) + "개");
        outputMessageLottoYield(amount,rankMap);
    }

    public static void outputMessageLottoYield(int amount, EnumMap<Rank, Integer> rankMap) {
        int sum = 0;
        for (Rank rank : rankMap.keySet()) {
            sum += rankMap.get(rank) * rank.getWinningMoney();
        }
        double yield = (double)sum/(double)amount;
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.2f", yield));
        System.out.print("입니다(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println();
    }


}
