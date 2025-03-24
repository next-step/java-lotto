package lotto;

import lotto.generator.CollectionShuffleLottoNumGenerator;
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

  public static void main(String[] args) {
    int price = showPriceInput();
    int lottoCount = LottoPurchaseCalculator.toLottoCount(price);
    showLottoCount(lottoCount);
    LottoBundle lottoBundle = LottoBundle.generate(lottoCount, new CollectionShuffleLottoNumGenerator());
    showLottoBundle(lottoBundle);
    List<LottoPrize> lottoPrizeList = lottoBundle.getLottoPrizes(WinningNums.valueOf(showWinningNums()));
    showLottoPrize(lottoPrizeList);
    showReturnRate(ReturnRateCalculator.calculate(price, LottoPrize.getTotalPrize(lottoPrizeList)));
  }
}
