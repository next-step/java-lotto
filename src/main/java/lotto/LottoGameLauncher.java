package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameLauncher {

    private static Lottos progressBuyingLottos(long inputPrice) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.buyLottos(inputPrice);
    }

    private static WinningResults progressMatchingLottos(Lottos lottos, String numbers) {
        Lotto winningLotto = new Lotto(LottoNumbers.valueOf(numbers));
        return lottos.matches(winningLotto);
    }

    public static void main(String[] args) {
        long inputPrice = InputView.inputPriceForBuying();
        Lottos lottos = progressBuyingLottos(inputPrice);
        ResultView.printLottos(lottos);

        String numbers = InputView.inputLastWinningNumbers();
        WinningResults winningResults = progressMatchingLottos(lottos, numbers);
        ProfitStatistics profitStatistics = new ProfitStatistics(winningResults, Money.from(inputPrice));
        ResultView.printStatistics(winningResults, profitStatistics);
    }
}
