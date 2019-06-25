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
        view.printRankGuide(LottoResultView.FIFTH_RANK_GUIDE,
                rankReward.getGainRankCounts()[Rank.FIFTH.ordinal()]);
        view.printRankGuide(LottoResultView.FOURTH_RANK_GUIDE,
                rankReward.getGainRankCounts()[Rank.FOURTH.ordinal()]);
        view.printRankGuide(LottoResultView.THIRD_RANK_GUIDE,
                rankReward.getGainRankCounts()[Rank.THIRD.ordinal()]);
        view.printRankGuide(LottoResultView.FIRST_RANK_GUIDE,
                rankReward.getGainRankCounts()[Rank.FIRST.ordinal()]);
        view.printRevenueRatioGuide(lottoPublisher.getRevenueRatio(
                rankReward.getRewardWinningMoney()),
                RevenueRatio.valueOf(lottoPublisher.getRevenueRatio(
                        rankReward.getRewardWinningMoney())).getName());
    }
}
