package step2.view;

import static step2.Constants.LOTTO_PRICE;
import static step2.view.Messages.RESPONSE_PRICE_TEMPLATE;
import static step2.view.Messages.WINNING_STATISTIC_RESULT_LOSS_CASE;
import static step2.view.Messages.WINNING_STATISTIC_TEMPLATE;

import java.util.List;
import step2.domain.LottoGameResultDto;
import step2.domain.Prize;
import step2.domain.UserLotto;

public class ResultView {

    public void printPriceResult(int price) {
        System.out.printf(RESPONSE_PRICE_TEMPLATE, price / LOTTO_PRICE);
    }

    public void printLottos(List<UserLotto> lottos) {
        lottos.stream().forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(UserLotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    public void printStatistic(LottoGameResultDto lottoGameResultDto) {
        System.out.printf(WINNING_STATISTIC_TEMPLATE,
            Prize.FIFTH.getCashPrize(),
            lottoGameResultDto.getFifthPrizeCount(),
            Prize.FORTH.getCashPrize(),
            lottoGameResultDto.getForthPrizeCount(),
            Prize.THIRD.getCashPrize(),
            lottoGameResultDto.getThirdPrizeCount(),
            Prize.SECOND.getCashPrize(),
            lottoGameResultDto.getSecondPrizeCount(),
            Prize.FIRST.getCashPrize(),
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
