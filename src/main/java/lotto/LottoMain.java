package lotto;

import java.util.List;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.LottoNumber;
import lotto.domains.LottoPurchasedAmount;
import lotto.domains.LottoStatistics;
import lotto.domains.LottoWinner;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        try {
            LottoGenerator lottoGenerator = new LottoGenerator();
            InputView inputView = new InputView();

            String moneyString = inputView.inputPurchaseMoney();
            List<Lotto> lottoList = lottoGenerator.purchaseByAuto(new LottoPurchasedAmount(moneyString));
            inputView.printPurchasedLottoList(lottoList);

            List<Integer> lastWinnerNumbers = inputView.inputLastWinner();
            Lotto lastWinnerLotto = new Lotto(lastWinnerNumbers);

            String bonusNumberString = inputView.inputBonusNumber();
            LottoNumber bonusNumber = new LottoNumber(bonusNumberString);

            LottoWinner lastWinner = new LottoWinner(lastWinnerLotto, bonusNumber);

            LottoStatistics statistics = new LottoStatistics(lottoList, lastWinner);

            ResultView resultView = new ResultView(statistics);
            resultView.printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
