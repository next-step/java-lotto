package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRankEnum;
import lotto.domain.WinningResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers numbers : lottoNumbers) {
            System.out.println(numbers.toString());
        }
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        LottoRankEnum.valuesWithoutMiss().stream().
                forEach(x-> System.out.println
                        (x.getDescription() + winningResult.getRankCount(x) + "개"));
    }

    private static void printResultByRankingInfo(Map<LottoRankEnum, Integer> winningResultMap, LottoRankEnum rank) {
        if (rank.equals(LottoRankEnum.LOSING_LOT)) {
            return;
        }
        int cnt = winningResultMap.get(rank) == null ? 0 : winningResultMap.get(rank);
        System.out.println(rank.getDescription() + cnt + "개");
    }

    public static void printRateOfReturnInfo(BigDecimal rateOfReturn) {
        String result = rateOfReturn.compareTo(new BigDecimal(1)) < 0 ? "손해" : "이득";
        System.out.println("총 수익률이" + rateOfReturn + "입니다. (기준이 1이기 때문에 결과적으로 " + result + "입니다.)");
    }
}
