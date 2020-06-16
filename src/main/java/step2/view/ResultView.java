package step2.view;

import static step2.view.Messages.RESPONSE_PRICE_TEMPLATE;
import static step2.view.Messages.WINNING_STATISTIC_RESULT_LOSS_CASE;
import static step2.view.Messages.WINNING_STATISTIC_TEMPLATE;

import step2.domain.LottoGameResultDto;
import step2.domain.LottoSheet;
import step2.domain.Prize;
import step2.domain.UserLotto;
import step2.domain.UserPrice;

public class ResultView {

    public void printPriceResult(UserPrice userPrice, int manualLottoCount) {
        System.out.printf(RESPONSE_PRICE_TEMPLATE, manualLottoCount, userPrice.getLottoCount(manualLottoCount));
    }

    public void printLottos(LottoSheet lottoSheet) {
        lottoSheet.getLottos().stream().forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(UserLotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    public void printStatistic(LottoGameResultDto lottoGameResultDto) {
        System.out.printf(WINNING_STATISTIC_TEMPLATE,
            Prize.FIFTH.getCashPrize(),
            lottoGameResultDto.getPrizeResult().getOrDefault(Prize.FIFTH, 0).intValue(),
            Prize.FORTH.getCashPrize(),
            lottoGameResultDto.getPrizeResult().getOrDefault(Prize.FORTH, 0).intValue(),
            Prize.THIRD.getCashPrize(),
            lottoGameResultDto.getPrizeResult().getOrDefault(Prize.THIRD, 0).intValue(),
            Prize.SECOND.getCashPrize(),
            lottoGameResultDto.getPrizeResult().getOrDefault(Prize.SECOND, 0).intValue(),
            Prize.FIRST.getCashPrize(),
            lottoGameResultDto.getPrizeResult().getOrDefault(Prize.FIRST, 0).intValue(),
            lottoGameResultDto.getEarningRate());
        printStatisticResult(lottoGameResultDto.getEarningRate());
    }

    private void printStatisticResult(double earningRate) {
        if (earningRate < 1) {
            System.out.println(WINNING_STATISTIC_RESULT_LOSS_CASE);
        }
    }
}
