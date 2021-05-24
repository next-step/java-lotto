package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameLauncher {

    private static Lottos progressBuyingLottos(long inputPrice, List<LottoNumbers> manuals) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(inputPrice, manuals);
    }

    private static WinningLotto progressInitWinningLotto(String numbers, int bonusBall) {
        return new WinningLotto(LottoNumbers.valueOf(numbers), LottoNumber.from(bonusBall));
    }

    private static List<LottoNumbers> progressInputManualNumbers(long manualCounts) {
        return InputView.inputManualNumbers(manualCounts);
    }

    public static void main(String[] args) {
        long inputPrice = InputView.inputPriceForBuying();
        long manualCounts = InputView.inputManualLottoCounts();
        List<LottoNumbers> manuals = progressInputManualNumbers(manualCounts);
        Lottos lottos = progressBuyingLottos(inputPrice, manuals);
        ResultView.printLottos(lottos);

        String numbers = InputView.inputLastWinningNumbers();
        int bonusBall = InputView.inputBonusNumber();
        WinningLotto winningLotto = progressInitWinningLotto(numbers, bonusBall);

        WinningResults winningResults = lottos.matches(winningLotto);
        ProfitStatistics profitStatistics = new ProfitStatistics(winningResults, Money.from(inputPrice));
        ResultView.printStatistics(winningResults, profitStatistics);
    }
}
