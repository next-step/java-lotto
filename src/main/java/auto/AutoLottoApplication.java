package auto;

import auto.application.AutoLottoService;
import auto.application.MatchLottoService;
import auto.application.MatchedAmount;
import auto.domain.Lotto;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLottoApplication {
    private static final AutoLottoService autoService = new AutoLottoService();
    private static final MatchLottoService matchService = new MatchLottoService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lottoCount = autoService.getLottoCount(purchaseAmount);
        ResultView.printLottoCounts(lottoCount);

        List<Lotto> totalLottoNumbers = autoService.createLottoNumbersList(lottoCount);
        ResultView.printTotalLottoNumbers(totalLottoNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        int bonusBallNumber = InputView.inputBonusBallNumber(winningNumbersLastWeek);

        Map<MatchedAmount, Integer> matchedCountMap = matchService.getMatchedCountMap(totalLottoNumbers,
                                                                                      winningNumbersLastWeek,
                                                                                      bonusBallNumber);
        ResultView.printLottoStats(matchedCountMap, purchaseAmount);
    }
}
