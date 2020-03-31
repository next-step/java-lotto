package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Price inputPrice = inputView.inputPrice();
        int manualCount = inputView.inputManualCount();

        List<LottoNumbers> manualLotteries = inputView.inputManualLottoNumbers(manualCount);
        Lotteries autoLotteries = LottoStore.sell(inputPrice, new LottoAutoPublisher(inputPrice.lotteryCount()));

        OutputView.printLotteryCount(autoLotteries.count());
        OutputView.printLotteries(autoLotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.inputLastWeekendWinningLottery();
        LottoNumber bonusBall = inputView.inputBonusBall();

        LottoResult lottoResult = autoLotteries.analyzeWin(winningLotteNumbers, bonusBall);

        OutputView.printLottoResult(lottoResult.getChart());
        OutputView.printRatio(lottoResult.ratio(inputPrice));
    }
}
