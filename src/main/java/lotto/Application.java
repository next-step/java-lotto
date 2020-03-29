package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        InputView inputView = new InputView();

        Price inputPrice = inputView.inputPrice();
        Lotteries lotteries = lotto.buy(inputPrice);

        OutputView.printLotteryCount(lotteries.count());
        OutputView.printLotteries(lotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.insertLastWeekendWinningLottery();
        LottoResult lottoResult = lotteries.analyzeWin(winningLotteNumbers);

        OutputView.printLottoResult(lottoResult.getChart());
        OutputView.printRatio(lottoResult.ratio(inputPrice));
    }
}
