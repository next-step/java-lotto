package lotto;

import lotto.generator.LottoNumGenerator;
import lotto.generator.CollectionsShuffleStrategy;
import lotto.type.BonusNum;
import lotto.type.LottoBundle;
import lotto.type.LottoPrize;
import lotto.type.WinningNums;
import lotto.util.LottoPurchaseCalculator;
import lotto.util.ReturnRateCalculator;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;


public class LottoSystem {

  public static void main(String[] args) {
    int price = showPriceInput();
    int lottoCount = LottoPurchaseCalculator.toLottoCount(price);

    showLottoCount(lottoCount);

    LottoBundle lottoBundle = LottoBundle.generate(
        lottoCount,
        new LottoNumGenerator(),
        new CollectionsShuffleStrategy()
    );
    showLottoBundle(lottoBundle);

    WinningNums winningNums = WinningNums.valueOf(showWinningNums());
    BonusNum bonusNum = BonusNum.valueOf(showBonusNumInput(), winningNums);
    List<LottoPrize> lottoPrizeList = lottoBundle.getLottoPrizes(winningNums, bonusNum);

    showLottoPrize(lottoPrizeList);
    showReturnRate(ReturnRateCalculator.calculate(price, LottoPrize.getTotalPrize(lottoPrizeList)));
  }
}
