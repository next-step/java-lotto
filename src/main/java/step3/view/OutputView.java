package step3.view;

import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.LottoResult;
import step3.domain.Rank;

import java.util.EnumMap;
import java.util.Set;

public class OutputView {

    public static void outputMessageLottoNumbers(Lottos lottos) {
        StringBuilder builder = new StringBuilder()
                .append(lottos.getLottoNumber().size())
                .append("개를 구매했습니다.");
        System.out.println(builder.toString());

        for (Lotto number : lottos.getLottoNumber()) {
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
