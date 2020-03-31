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
        List<LottoNumbers> inputManualLottoNumbers = inputView.inputManualLottoNumbers(manualCount);

        Lotteries lotteries = LottoStore.sell(inputPrice, inputManualLottoNumbers);

        OutputView.printLotteryCount(manualCount, lotteries.count());
        OutputView.printLotteries(lotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.inputLastWeekendWinningLottery();
        LottoNumber bonusBall = inputView.inputBonusBall();

        LottoResult lottoResult = lotteries.analyzeWin(winningLotteNumbers, bonusBall);

        OutputView.printLottoResult(lottoResult.getChart());
        OutputView.printRatio(lottoResult.ratio(inputPrice));
    }
}
