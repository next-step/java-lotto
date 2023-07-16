package lotto.view;

import lotto.response.LottoRankResponse;
import lotto.response.LottoResultResponse;
import lotto.response.LottoStatusResponse;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";

    public void printBuyStatus(LottoStatusResponse lottoStatusResponse) {
        long manualCount = lottoStatusResponse.getManualCount();
        long autoCount = lottoStatusResponse.getLottoStatus().size() - manualCount;
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount);
        System.out.println();
        for (List<Integer> lottoStatus : lottoStatusResponse.getLottoStatus()) {
            Collections.sort(lottoStatus);
            System.out.println(lottoStatus);
        }
        System.out.println();

    }

    public void printLottoResult(LottoResultResponse lottoResultResponse) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        List<LottoRankResponse> lottoRankResponses = lottoResultResponse.getLottoRankResponses();
        for (LottoRankResponse lottoRankResponse : lottoRankResponses) {
            printRankResult(lottoRankResponse);
        }

        System.out.printf("총 수익률은 %.2f입니다.", lottoResultResponse.getProfitRate());
    }

    private void printRankResult(LottoRankResponse lottoRankResponse) {
        String message = lottoRankResponse.isBonusMatch() ? BONUS_RESULT_MESSAGE : RESULT_MESSAGE;
        System.out.printf(message, lottoRankResponse.getMatchCount(), lottoRankResponse.getPrice(), lottoRankResponse.getLottoCount());
        System.out.println();
    }
}
