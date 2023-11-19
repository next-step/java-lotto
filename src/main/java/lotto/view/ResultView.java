package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.Map;

public class ResultView {

    public static void printPurchaseInfo(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public void printLottoNumbers(Lotto[] lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.numbers().toString());
        }
        System.out.println();
    }

    public void printWinningStatistics(Map<LottoResult, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoResults.remove(LottoResult.FAIL);

        for (Map.Entry<LottoResult, Integer> entry : lottoResults.entrySet()) {
            LottoResult lottoResult = entry.getKey();
            System.out.println(
                    String.format("%d개 일치 (%d원)- %d개",
                            lottoResult.matchCount(),
                            lottoResult.prize(),
                            entry.getValue())
            );
        }
    }

}
