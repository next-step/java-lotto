package lotto.view;

import java.util.List;

import lotto.dto.LottoPurchasedDto;
import lotto.dto.LottoResultDto;

public class ResultView {
    public static void printLottoPurchaseResult(LottoPurchasedDto lottoOrderedDto) {
        System.out.printf("%d개를 구매했습니다.\n", lottoOrderedDto.getPurchasedLottoCount());

        List<String> lottoNumberList = lottoOrderedDto.getLottoNumberList();
        lottoNumberList.forEach(System.out::println);
    }

    public static void printLottoDrawResult(LottoResultDto lottoResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d)- %d개\n",
                i, lottoResultDto.getPrizeByCountMatches(i),
                lottoResultDto.getWinnerCountByCountMatches(i));
        }
        String earningRate = lottoResultDto.getEarningRate();
        System.out.printf("총 수익률은 " + earningRate + "입니다.");
        if (Double.parseDouble(earningRate) < 1) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
        }
    }
}
