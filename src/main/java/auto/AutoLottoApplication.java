package auto;

import auto.application.AutoLottoService;
import auto.application.MatchLottoService;
import auto.application.MatchedAmount;
import auto.domain.Lotto;
import auto.domain.Lottos;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.Map;

public class AutoLottoApplication {
    private static final AutoLottoService autoService = new AutoLottoService();
    private static final MatchLottoService matchService = new MatchLottoService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lottoCount = autoService.getLottoCount(purchaseAmount);
        ResultView.printLottoCounts(lottoCount);

        Lottos totalLottoNumbers = Lottos.createLottoNumbersList(lottoCount);
        ResultView.printTotalLottoNumbers(totalLottoNumbers);

        Lotto winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        int bonusBallNumber = InputView.inputBonusBallNumber(winningNumbersLastWeek);

        Map<MatchedAmount, Integer> matchedCountMap = matchService.getMatchedCountMap(totalLottoNumbers,
                                                                                      winningNumbersLastWeek,
                                                                                      bonusBallNumber);
        ResultView.printLottoStats(matchedCountMap, purchaseAmount);
    }
}
