package lotto;

import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int price = InputView.inputPrice();
        LottoShop lottoShop = new LottoShop();

        lottoShop.buyAuto(price);
        ResultView.printLottoNumbers(lottoShop.getLottoBundle());

        String winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();

        LottoResult lottoResult = lottoShop.checkWinning(winningNumber, bonusNumber);
        ResultView.printResult(lottoResult);
    }
}
