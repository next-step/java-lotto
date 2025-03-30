package lotto.view;

import lotto.LottoNumbers;
import lotto.LottoRank;

import java.util.Map;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printStat(double rateOfReturn, Map<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            printLottoRankStatWhenLottoRankIsNotETC(lottoRank, rankCount);
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", rateOfReturn);
    }

    private static void printLottoRankStatWhenLottoRankIsNotETC(LottoRank lottoRank, Map<LottoRank, Integer> rankCount) {
        if (lottoRank == LottoRank.ETC)
            return;

        System.out.printf("%d개 일치 (%d원)- %d개\n", lottoRank.getMatchCount(), lottoRank.getMoney(), rankCount.getOrDefault(lottoRank, 0));
    }
}
