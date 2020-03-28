package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        InputView inputView = new InputView();

        Lotteries lotteries = lotto.buy(inputView.inputPrice());

        OutputView.printLotteryCount(lotteries.count());
        OutputView.printLotteries(lotteries.getLottoNumbers());

        LottoNumbers winningLotteNumbers = inputView.insertLastWeekendWinningLottery();
    }
}
