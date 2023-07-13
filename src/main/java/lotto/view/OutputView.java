package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";

    public void printBuyStatus(LottoStatusResponseDto lottoStatusResponseDto) {
        System.out.println(lottoStatusResponseDto.getLottoStatus().size() + "개를 구매했습니다.");
        for (List<Integer> lottoStatus : lottoStatusResponseDto.getLottoStatus()) {
            Collections.sort(lottoStatus);
            System.out.println(lottoStatus);
        }
        System.out.println();
    }

    public void printLottoResult(LottoResultResponseDto lottoResultResponseDto) {
        Map<LottoRank, Long> lottoResults = lottoResultResponseDto.getLottoResults();
        System.out.println("당첨 통계");
        System.out.println("--------");

        List<LottoRank> lottoRanks = Arrays.stream(LottoRank.values()).collect(Collectors.toList());
        Collections.reverse(lottoRanks);

        for (LottoRank rank : lottoRanks) {
            printRankResult(rank, lottoResults.getOrDefault(rank, 0L));
        }

        System.out.printf("총 수익률은 %.2f입니다.", lottoResultResponseDto.getProfitRate());
    }

    private void printRankResult(LottoRank rank, long lottoCount) {
        if (rank == LottoRank.NONE) {
            return;
        }
        if (rank == LottoRank.SECOND) {
            System.out.printf(SECOND_RESULT_MESSAGE, rank.getMatchCount(), rank.getPrice(), lottoCount);
            System.out.println();
            return;
        }
        System.out.printf(RESULT_MESSAGE, rank.getMatchCount(), rank.getPrice(), lottoCount);
        System.out.println();
    }
}
