package lotto;

import lotto.domain.*;
import lotto.view.LottoResultView;

public class LottoController {

    public static void main(String[] args) {
        LottoResultView view = new LottoResultView();
        view.printPurchaseAmountGuide();

        LottoPublisher publisher = new LottoPublisher(view.getInputAmout());
        view.printBuyLottoCountGuide(publisher.getPublishLotto().size());

        view.printPublishLottoNumbers(view.getLottosNumbers(publisher.getPublishLotto()));

        view.printWinnerNumbersGuide();
        WinnerLotto winnerLotto = new WinnerLotto(view.getInputWinnerNumbers());
        view.printBonusNumberGuide();
        BonusNumber bonusNumber = new BonusNumber(view.getInputBonusNumber());
        RankReward rankReward = new RankReward(publisher.getPublishLottoRanks(
                winnerLotto, bonusNumber.getNumber()));

        view.printWinnerStatisticsGuide();
        view.printRankGuide(rankReward.getGainRanksCounts());

        view.printRevenueRatioGuide(publisher.getRevenueRatio(
                rankReward.getRewardWinningMoney()),
                RevenueRatio.valueOf(publisher.getRevenueRatio(
                        rankReward.getRewardWinningMoney())).getName());
    }
}
