package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchasePrice = inputView.askPurchasePrice();

        int lottoCount = purchasePrice / 1000;
        ResultView.printPurchaseInfo(lottoCount);

        Lotto[] lottoList = new Lotto[lottoCount];
        for (int index = 0; index < lottoCount; index++) {
            lottoList[index] = new Lotto();
            resultView.printLottoNumbers(lottoList[index]);
        }
    }

}
