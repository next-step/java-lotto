package lotto.ui;


import lotto.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

import java.util.List;


public class PrintView {
    private static final List<LottoRank> PRINT_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
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

    public static void printWinningCount(LottoResult lottoResult) {
        for (LottoRank lottoRank : PRINT_RANKS) {
            System.out.printf(convertRankToText(lottoRank),lottoRank.lottoMatchingCount(), lottoRank.lottoWinningAmount(),
                    lottoResult.countRank(lottoRank));
        }
    }

    public static void printMargin(double marginAmount) {
        System.out.println("총 수익률은 " + marginAmount + "입니다.");

    }

    public static String convertRankToText(LottoRank rank) {
        if (rank.equals(LottoRank.SECOND)) {
            return LOTTO_RESULT_WITH_BONUS_TEXT;
        }
        return LOTTO_RESULT_TEXT;
    }

}
