package auto;

import auto.application.AutoLottoService;
import auto.application.MatchLottoService;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLottoApplication {
    private static final AutoLottoService autoLottoService = new AutoLottoService();
    private static final MatchLottoService matchLottoService = new MatchLottoService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lotteryCount = autoLottoService.getLottoCount(purchaseAmount);
        ResultView.printLottoCounts(lotteryCount);

        List<List<Integer>> totalLottoNumbers = autoLottoService.createLottoNumbersList(lotteryCount);
        ResultView.printTotalLottoNumbers(totalLottoNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = matchLottoService.getMatchedCountMap(totalLottoNumbers, winningNumbersLastWeek);
        ResultView.printLottoStats(matchedCountMap, purchaseAmount);
    }
}
