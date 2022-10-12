package lotto;

import java.util.List;
import lotto.domains.Lotto;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            List<Lotto> lottos = inputView.inputPurchase();
            Lotto winner = inputView.inputLastWinner();

            ResultView resultView = new ResultView(lottos, winner);
            resultView.printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
