package lotto.ui;


import lotto.LottoWinningCountDecision;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static lotto.LottoRank.convertRankToMatchingCount;


public class PrintView {

    public static final String LOTTO_RESULT_WITH_BONUS_TEXT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    public static final String LOTTO_RESULT_TEXT = "%d개 일치 (%d원)- %d개\n";

    public static void printLottoTryCount(int lottoTryCount) {
        System.out.println(lottoTryCount + "개를 구매했습니다.");

    }

    public static void printLottoList(Lotto lotto) {
        for(LottoNumbers lottoNumbers :lotto.totalRoundLottoNumberList()) {
            System.out.println(lottoNumbers.getLottoNumbers());
        }
    }

    public static void printWinningStatisticsPreview() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printWinningCount(Map<Integer, Integer> winningLottoCountMap) {
        for (int rank : winningLottoCountMap.keySet()) {
            System.out.printf(convertRankToText(rank), convertRankToMatchingCount(rank),
                    LottoWinningCountDecision.convertMatchingRankToAmount(rank), winningLottoCountMap.get(rank));
        }
    }

    public static void printMargin(double marginAmount) {
        System.out.println("총 수익률은 " + marginAmount + "입니다.");

    }

    public static String convertRankToText(int rank) {
        if (rank == 2) {
            return LOTTO_RESULT_WITH_BONUS_TEXT;
        }
        return LOTTO_RESULT_TEXT;
    }

}
