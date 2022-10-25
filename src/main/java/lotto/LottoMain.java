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
            ResultView resultView = new ResultView();

            List<Lotto> lottoList = lottoGenerator.purchaseByAuto(LottoPurchasedAmount.of(inputView.inputPurchaseMoney()));
            inputView.printPurchasedLottoList(lottoList);

            Lotto lastWinnerLotto = Lotto.createByString(inputView.inputLastWinner());
            LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
            LottoWinner lastWinner = new LottoWinner(lastWinnerLotto, bonusNumber);

            resultView.printStatistics(new LottoStatistics(lottoList, lastWinner));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
