package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringResultDto;
import lotto.view.dto.LottoWinnerDto;

public class ResultView {
    public static void printLottoOrderResult(LottoOrderResultDto lottoOrderResultDto) {
        System.out.printf("%d개를 구매했습니다.\n", lottoOrderResultDto.getOrderedResult().size());

        List<LottoDto> lottoNumberList = lottoOrderResultDto.getOrderedResult();
        lottoNumberList.forEach(number -> System.out.println("[" + number + "]"));
    }

    public static void printLottoScoringResult(LottoScoringResultDto lottoScoringResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoWinnerDto> winnerDtoList = lottoScoringResultDto.getWinnerDtoList();
        Collections.sort(winnerDtoList);

        for (LottoWinnerDto winnerDto : winnerDtoList) {
            System.out.print(winnerDto);
        }
        String earningRate = lottoScoringResultDto.getEarningRate();
        System.out.printf("총 수익률은 " + earningRate + "입니다.");
        if (Double.parseDouble(earningRate) < 1) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n");
        }
    }
}
