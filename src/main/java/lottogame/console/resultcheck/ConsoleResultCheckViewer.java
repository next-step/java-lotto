package lottogame.console.resultcheck;

import java.util.Map;
import lottogame.controller.resultcheck.spi.ResultCheckViewer;
import lottogame.domain.LottoPrize;
import lottogame.service.response.LottoCheckResponse;

public class ConsoleResultCheckViewer implements ResultCheckViewer {

    @Override
    public void draw(LottoCheckResponse lottoCheckResponse) {
        System.out.println("당첨 통계\n---------");
        lottoCheckResponse.getLottoPrizes().entrySet().forEach(this::printLottoPrize);
        printEarningRate(lottoCheckResponse.getEarningRate());
    }

    private void printLottoPrize(Map.Entry<LottoPrize, Integer> lottoPrizeCount) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", lottoPrizeCount.getKey().getMatchedCount(),
            lottoPrizeCount.getKey().getMoney(), lottoPrizeCount.getValue());
    }

    private void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", earningRate);
    }
}
