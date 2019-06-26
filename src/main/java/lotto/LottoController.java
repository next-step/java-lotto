package lotto;

import lotto.domain.*;
import lotto.view.LottoResultView;

public class LottoController {

    public static void main(String[] args) {

        LottoResultView view = new LottoResultView();
        view.printPurchaseAmountGuide();

        LottoPublisher lottoPublisher = new LottoPublisher(view.getInputAmout());
        view.printBuyLottoCountGuide(lottoPublisher.getPublishLotto().size());

        view.printPublishLottoNumbers(view.getLottosNumbers(lottoPublisher.getPublishLotto()));

        view.printWinnerNumbersGuide();
        WinnerLotto winnerLotto = new WinnerLotto(view.getInputWinnerNumbers());
        view.printBonusNumberGuide();
        BonusNumber bonusNumber = new BonusNumber(view.getInputBonusNumber());
        RankReward rankReward = new RankReward(lottoPublisher.getPublishLottoRanks(
                winnerLotto, bonusNumber.getNumber()));

        view.printWinnerStatisticsGuide();
        view.printRankGuide(rankReward.getGainRanksCounts());

        view.printRevenueRatioGuide(lottoPublisher.getRevenueRatio(
                rankReward.getRewardWinningMoney()),
                RevenueRatio.valueOf(lottoPublisher.getRevenueRatio(
                        rankReward.getRewardWinningMoney())).getName());
    }
}
