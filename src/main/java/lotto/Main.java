package lotto;

import lotto.domain.LottoAgent;
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
        LottoAgent lottoAgent = LottoAgent.newInstance();
        lottoAgent.buy(price, RandomSelectionStrategy.getInstance());
        PurchasedLottosDTO purchasedLottos = lottoAgent.getPurchasedLottos();
        ResultView.printPurchasedLottos(purchasedLottos);
        List<Integer> winnerNumbers = InputView.winnerNumbersInput();
        lottoAgent.decideWinningNumbers(WinningNumbersDTO.valueOf(winnerNumbers));
        LottoStatisticsDTO statistics = lottoAgent.getStatistics();
        ResultView.printLottoStatistics(statistics);
    }
}
