package step2.view;

import static step2.view.Messages.RESPONSE_PRICE_TEMPLATE;
import static step2.view.Messages.WINNING_STATISTIC_RESULT_LOSS_CASE;
import static step2.view.Messages.WINNING_STATISTIC_TEMPLATE;

import java.util.List;
import step2.domain.LottoGameResultDto;

public class ResultView {
    public void printPriceResult(int price) {
        System.out.printf(RESPONSE_PRICE_TEMPLATE, price);
    }

    public void printLottos(List<List<Integer>> lottos) {
        lottos.stream().forEach(this::printLotto);
    }

    private void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printStatistic(LottoGameResultDto lottoGameResultDto) {
        System.out.printf(WINNING_STATISTIC_TEMPLATE,
            lottoGameResultDto.getForthPrizeCount(),
            lottoGameResultDto.getThirdPrizeCount(),
            lottoGameResultDto.getSecondPrizeCount(),
            lottoGameResultDto.getThirdPrizeCount(),
            lottoGameResultDto.getFirstPrizeCount(),
            lottoGameResultDto.getEarningRate());
        printStatisticResult(lottoGameResultDto.getEarningRate());
    }

    private void printStatisticResult(double earningRate) {
        if (earningRate < 1) {
            System.out.println(WINNING_STATISTIC_RESULT_LOSS_CASE);
        }
    }
}
