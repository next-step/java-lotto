package lotto;

import lotto.domain.*;
import lotto.view.LottoResultView;

public class LottoController {

    public static void main(String[] args) {

        LottoResultView view = new LottoResultView();
        view.printPurchaseAmountGuide();

        LottoPublisher lottoPublisher = new LottoPublisher(view.getInputAmout());
        view.printBuyLottoCountGuide(lottoPublisher.getPublishLotto().size());

        view.printPublishLottoNumbers(lottoPublisher.getBuyLottoCount(),
                lottoPublisher.getLottosNumbers());

        view.printWinnerNumbersGuide();
        RankReward rankReward = new RankReward(lottoPublisher.getPublishLottoRanks(
                new WinnerLotto(view.getInputWinnerNumbers())));

        view.printWinnerStatisticsGuide();
        view.printRankGuide(rankReward.getGainRanksCounts());

        view.printRevenueRatioGuide(lottoPublisher.getRevenueRatio(
                rankReward.getRewardWinningMoney()),
                RevenueRatio.valueOf(lottoPublisher.getRevenueRatio(
                        rankReward.getRewardWinningMoney())).getName());
    }
}
