package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }
    
    public static void printLottos(List<List<LottoNumber>> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult, double profitability) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<LottoRank, Integer> resultMap = lottoResult.getResultMap();
        resultMap.forEach((lottoRank, integer) -> {
            System.out.printf("%d개 일치 (%d원)- %d개%n", lottoRank.getMatchCount(), lottoRank.getWinningPrize(), integer);
        });
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(profitability);
        System.out.print("총 수익률은 " + formattedValue + "입니다.");
        if (profitability < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (profitability > 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
        }
    }
}
