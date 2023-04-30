package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoStatisticsDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void outputLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void outputLottoNumbers(LottoNumbersDto dto) {
        List<List<Integer>> lottoNumbers = dto.getLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            outputLottoNumber(lottoNumber);
        }
        System.out.println();
    }

    private static void outputLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void outputLottoStatistics(LottoStatisticsDto dto) {
        Map<LottoRank, Integer> matchingCounts = dto.getMatchingCounts();
        System.out.printf("%n당첨 통계%n");
        System.out.println("---------");

        List<LottoRank> ranks = new ArrayList<>(matchingCounts.keySet());
        Collections.sort(ranks, Collections.reverseOrder());
        for (LottoRank rank : ranks) {
            outputStatisticsStage(matchingCounts, rank);
        }

        outputGrossRateOfEarnings(dto);
    }

    private static void outputStatisticsStage(Map<LottoRank, Integer> matchingCounts,
                                              LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개%n",
                    rank.getMatchCount(), rank.getPrizeMoney(), matchingCounts.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%d원)- %d개%n",
                rank.getMatchCount(), rank.getPrizeMoney(), matchingCounts.get(rank));
    }

    private static void outputGrossRateOfEarnings(LottoStatisticsDto dto) {
        double grossRateOfEarnings = dto.getGrossRateOfEarnings();
        if (grossRateOfEarnings >= 1) {
            System.out.printf("총 수익률은 %.2f입니다.", grossRateOfEarnings);
            return;
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
                , grossRateOfEarnings);
    }
}
