package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameLauncher {

    private static Lottos progressBuyingLottos(long inputPrice) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(inputPrice);
    }

    private static WinningResult progressMatchingLottos(Lottos lottos, String numbers) {
        Lotto winningLotto = new Lotto(LottoNumbers.valueOf(numbers));
        return lottos.matches(winningLotto);
    }

    public static void main(String[] args) {
        long inputPrice = InputView.inputPriceForBuying();
        Lottos lottos = progressBuyingLottos(inputPrice);
        ResultView.printLottos(lottos);

        String numbers = InputView.inputLastWinningNumbers();
        WinningResult winningResult = progressMatchingLottos(lottos, numbers);
        ProfitStatistics profitStatistics = new ProfitStatistics(winningResult, Money.from(inputPrice));
        ResultView.printStatistics(winningResult, profitStatistics);
    }
}
