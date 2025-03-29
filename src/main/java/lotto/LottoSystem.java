package lotto;

import lotto.strategy.pick.RandomNumberPickStrategy;
import lotto.strategy.shuffle.CollectionsShuffleStrategy;
import lotto.type.LottoNumber;
import lotto.type.LottoNumbers;
import lotto.type.LottoNumbersBundle;
import lotto.type.LottoPrize;
import lotto.util.LottoPurchaseCalculator;
import lotto.util.ReturnRateCalculator;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;


public class LottoSystem {

  public static void main(String[] args) {
    int price = showPriceInput();
    int lottoCount = LottoPurchaseCalculator.toLottoCount(price);
    List<String> manualLottoNumbersBundle = showManualLottoNumbersBundle(showManualPurchaseCount());
    int toCreateLottoCount = lottoCount - manualLottoNumbersBundle.size();
    LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle(
        toCreateLottoCount,
        manualLottoNumbersBundle,
        new LottoCreateStrategyContext(new RandomNumberPickStrategy(), new CollectionsShuffleStrategy())
    );

    showLottoCount(toCreateLottoCount, manualLottoNumbersBundle.size());

    showLottoBundle(lottoNumbersBundle);

    List<LottoPrize> lottoPrizeList = lottoNumbersBundle.getLottoPrizes(new LottoNumbers(showWinningNums()), new LottoNumber(showBonusNumInput()));
    showLottoPrize(lottoPrizeList);

    showReturnRate(ReturnRateCalculator.calculate(price, LottoPrize.getTotalPrize(lottoPrizeList)));
  }
}
