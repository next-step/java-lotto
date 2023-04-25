package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        ResultView.printPurchasePriceInputCommand();
        long purchasePrice = new InputView().LongInput();
        long lottoCount = Lotto.lottoCount(purchasePrice);
        ResultView.printLottoCount(lottoCount);
        ResultView.printAllLottoNumbers(Lotto.generateAllLottoNumbers(lottoCount));

    }

}
