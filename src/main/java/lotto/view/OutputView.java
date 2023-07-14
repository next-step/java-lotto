package lotto.view;

import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
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
        System.out.println("당첨 통계");
        System.out.println("--------");

        List<LottoRankDto> lottoRankDtos = lottoResultResponseDto.getLottoRankDtos();
        for (LottoRankDto lottoRankDto : lottoRankDtos) {
            printRankResult(lottoRankDto);
        }

        System.out.printf("총 수익률은 %.2f입니다.", lottoResultResponseDto.getProfitRate());
    }

    private void printRankResult(LottoRankDto lottoRankDto) {
        String message = lottoRankDto.isBonusMatch() ? BONUS_RESULT_MESSAGE : RESULT_MESSAGE;
        System.out.printf(message, lottoRankDto.getMatchCount(), lottoRankDto.getPrice(), lottoRankDto.getLottoCount());
        System.out.println();
    }
}
