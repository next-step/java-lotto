package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int price = InputView.inputPrice();
        LottoShop lottoShop = new LottoShop();

        LottoBundle lottoBundle = lottoShop.buyAuto(price);
        ResultView.printLottoNumbers(lottoBundle);

        String winningNumber = InputView.inputWinningNumber();

        LottoResult lottoResult = lottoShop.checkWinning(lottoBundle, winningNumber);
        ResultView.printResult(lottoResult);
    }
}
