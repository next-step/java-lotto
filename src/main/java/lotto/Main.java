package lotto;

import lotto.domain.LottoManager;
import lotto.domain.RandomSelectionStrategy;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;
import lotto.dto.WinningNumbersDTO;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int price = InputView.priceInput();
        LottoManager lottoManager = LottoManager.newInstance();
        lottoManager.buy(price, RandomSelectionStrategy.getInstance());
        PurchasedLottosDTO purchasedLottos = lottoManager.getPurchasedLottos();
        ResultView.printPurchasedLottos(purchasedLottos);
        List<Integer> winnerNumbers = InputView.winnerNumbersInput();
        lottoManager.decideWinningNumbers(WinningNumbersDTO.valueOf(winnerNumbers));
        LottoStatisticsDTO statistics = lottoManager.getStatistics();
        ResultView.printLottoStatistics(statistics);
    }
}
