package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameLauncher {

    private static Lottos progressBuyingLottos(long inputPrice) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(inputPrice);
    }

    private static WinningLotto progressInitWinningLotto(String numbers, int bonusBall) {
        return new WinningLotto(LottoNumbers.valueOf(numbers), LottoNumber.from(bonusBall));
    }

    public static void main(String[] args) {
        long inputPrice = InputView.inputPriceForBuying();
        Lottos lottos = progressBuyingLottos(inputPrice);
        ResultView.printLottos(lottos);

        String numbers = InputView.inputLastWinningNumbers();
        int bonusBall = InputView.inputBonusNumber();
        WinningLotto winningLotto = progressInitWinningLotto(numbers, bonusBall);

        WinningResults winningResults = lottos.matches(winningLotto);
        ProfitStatistics profitStatistics = new ProfitStatistics(winningResults, Money.from(inputPrice));
        ResultView.printStatistics(winningResults, profitStatistics);
    }
}
