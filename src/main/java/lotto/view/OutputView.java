package lotto.view;

import lotto.Lotto;
import lotto.LottoRankingEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void printWinningResult(Map<LottoRankingEnum, Integer> winningResultMap) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (LottoRankingEnum rank : LottoRankingEnum.values()) {

            printResultByRankingInfo(winningResultMap, rank);
        }
    }

    private static void printResultByRankingInfo(Map<LottoRankingEnum, Integer> winningResultMap, LottoRankingEnum rank) {
       if(rank.equals(LottoRankingEnum.LOSING_LOT)) {
           return ;
       }
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = winningResultMap.get(rank) == null ? 0 : winningResultMap.get(rank);
        stringBuilder.append(rank.getMatchCnt()).append("개 일치 (").append(rank.getWinningAmount().toString()).append(")-").append(cnt).append("개");
        System.out.println(stringBuilder.toString());
    }

    public static void printRateOfReturnInfo(BigDecimal rateOfReturn) {
        String result = rateOfReturn.compareTo(new BigDecimal(1)) < 0 ? "손해" : "이득";
        System.out.println("총 수익률이" +rateOfReturn+"입니다. (기준이 1이기 때문에 결과적으로 " + result +"입니다.)");
    }
}
