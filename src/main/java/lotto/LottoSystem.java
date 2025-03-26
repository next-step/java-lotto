package lotto;

import lotto.generator.LottoNumGenerator;
import lotto.generator.CollectionsShuffleStrategy;
import lotto.type.LottoBundle;
import lotto.type.LottoPrize;
import lotto.type.WinningNums;
import lotto.util.LottoPurchaseCalculator;
import lotto.util.ReturnRateCalculator;

import java.util.List;

import static lotto.view.InputView.showPriceInput;
import static lotto.view.InputView.showWinningNums;
import static lotto.view.OutputView.*;


public class LottoSystem {

  private static final int LOTTO_MAX_NUM = 45;
  private static final int LOTTO_SIZE = 6;

  public static void main(String[] args) {
    int price = showPriceInput();
    int lottoCount = LottoPurchaseCalculator.toLottoCount(price);

    showLottoCount(lottoCount);

    LottoBundle lottoBundle = LottoBundle.generate(
        lottoCount,
        new LottoNumGenerator(LOTTO_SIZE, LOTTO_MAX_NUM),
        new CollectionsShuffleStrategy()
    );
    showLottoBundle(lottoBundle);

//    List<LottoPrize> lottoPrizeList = lottoBundle.getLottoPrizes(
//        WinningNums.valueOf(showWinningNums(), LOTTO_SIZE)
//    );
//    showLottoPrize(lottoPrizeList);
//    showReturnRate(ReturnRateCalculator.calculate(price, LottoPrize.getTotalPrize(lottoPrizeList)));
  }
}
