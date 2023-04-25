package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        ResultView.printPurchasePriceInputCommand();
        long purchasePrice = Long.parseLong(inputView.nextLine());
        long lottoCount = Lotto.lottoCount(purchasePrice);
        ResultView.printLottoCount(lottoCount);
        ResultView.printAllLottoNumbers(Lotto.generateAllLottoNumbers(lottoCount));

        ResultView.printWinningLottoNumberInputCommand();
        String winningLottoNumberStr = inputView.nextLine();


        inputView.close();
    }
}
