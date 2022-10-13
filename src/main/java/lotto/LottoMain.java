package lotto;

import java.util.List;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.LottoStatistics;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        try {
            LottoGenerator lottoGenerator = new LottoGenerator();
            InputView inputView = new InputView();

            int money = inputView.inputPurchaseMoney();
            List<Lotto> lottoList = lottoGenerator.purchaseByAuto(money);
            lottoList.forEach(System.out::println);

            List<Integer> lastWinnerNumbers = inputView.inputLastWinner();
            Lotto lastWinner = new Lotto(lastWinnerNumbers);

            LottoStatistics statistics = new LottoStatistics(lottoList, lastWinner);

            ResultView resultView = new ResultView(statistics);
            resultView.printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
