package auto;

import auto.application.AutoService;
import auto.application.MatchService;
import auto.domain.Lotto;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoApplication {
    private static final int LOTTO_PRICE = 1000;
    private static final AutoService autoService = new AutoService();
    private static final MatchService matchService = new MatchService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        ResultView.printLottoCounts(lottoCount);

        List<Lotto> totalLottoNumbers = autoService.createLottoNumbersList(lottoCount);
        ResultView.printTotalLottoNumbers(totalLottoNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = matchService.getMatchedCountMap(totalLottoNumbers, winningNumbersLastWeek);
        ResultView.printLottoStats(matchedCountMap, purchaseAmount);
    }
}
