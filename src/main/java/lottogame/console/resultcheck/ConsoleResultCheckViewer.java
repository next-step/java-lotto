package lottogame.console.resultcheck;

import java.util.Map;
import lottogame.controller.resultcheck.spi.ResultCheckViewer;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketCheckedResponse;

public class ConsoleResultCheckViewer implements ResultCheckViewer {

    @Override
    public void draw(LottoCheckedResponse lottoCheckedResponse) {
        System.out.println("당첨 통계\n---------");
        lottoCheckedResponse.getLottoTicketCheckResponses().entrySet().forEach(this::printLottoPrize);
        printEarningRate(lottoCheckedResponse.getEarningRate());
    }

    private void printLottoPrize(Map.Entry<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", lottoTicketCheckResponses.getKey().getMatchedCount(),
            lottoTicketCheckResponses.getKey().getMoney(), lottoTicketCheckResponses.getValue());
    }

    private void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", earningRate);
    }
}