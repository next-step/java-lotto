package lotto.view;

import lotto.LottoRank;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printBuyStatus(LottoStatusResponseDto lottoStatusResponseDto) {
        System.out.println(lottoStatusResponseDto.getLottoStatus().size() + "개를 구매했습니다.");
        for (List<Integer> lottoStatus : lottoStatusResponseDto.getLottoStatus()) {
            System.out.println(lottoStatus);
        }
        System.out.println();
    }

    public void printLottoResult(LottoResultResponseDto lottoResultResponseDto) {
        Map<LottoRank, Long> lottoResults = lottoResultResponseDto.getLottoResults();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원) - " + lottoResults.getOrDefault(LottoRank.FIFTH, 0L) + "개");
        System.out.println("4개 일치 (50000원) - " + lottoResults.getOrDefault(LottoRank.FOURTH, 0L) + "개");
        System.out.println("5개 일치 (1500000원) - " + lottoResults.getOrDefault(LottoRank.THIRD, 0L) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + lottoResults.getOrDefault(LottoRank.SECOND, 0L) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottoResults.getOrDefault(LottoRank.FIRST, 0L) + "개");
        System.out.printf("총 수익률은 %.2f입니다.", lottoResultResponseDto.getProfitRate());
    }
}
