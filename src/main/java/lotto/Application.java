package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Price inputPrice = inputView.inputPrice();
        Lotteries lotteries = LottoStore.buy(inputPrice);

        OutputView.printLotteryCount(lotteries.count());
        OutputView.printLotteries(lotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.inputLastWeekendWinningLottery();
        BonusBall bonusBall = inputView.inputBonusBall();

        LottoResult lottoResult = lotteries.analyzeWin(winningLotteNumbers, bonusBall);

        OutputView.printLottoResult(lottoResult.getChart());
        OutputView.printRatio(lottoResult.ratio(inputPrice));
    }
}
