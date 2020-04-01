package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        int price = InputView.getPrice();

        LottoGame lottoGame = new LottoGame();
        int purchaseCount = lottoGame.purchaseLotto(price);

        ResultView.printPurChaseCount(purchaseCount);
        List<Lotto> lottos = lottoGame.createLottos(purchaseCount);

        ResultView.printLottoNumbers(lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);

        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = lottoGame.match(lotto, winningLotto);
            results.add(lottoGame.getRank(matchCount));
        }

        ResultView.printWinningStatus(results);

        int totalWinnings = lottoGame.getTotalWinnings(results);
        double rateOfRevenue = lottoGame.getRateOfRevenue(price, totalWinnings);

        ResultView.printRateOfRevenue(rateOfRevenue);
    }
}
