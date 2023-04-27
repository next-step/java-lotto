package lotto;

import lotto.data.Lotto;

import java.util.List;

import static lotto.view.InputView.getPurchaseAmount;
import static lotto.view.InputView.getWinningNumbers;
import static lotto.service.LottoGame.*;
import static lotto.view.ResultView.*;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int amount = getAmountOfLotto(purchaseAmount);
        viewAmount(amount);

        List<Lotto> lottoList = getLottoList(amount);
        viewLottoList(lottoList);

        Lotto winningNumbers = getWinningNumbers();
        viewWinningNumberList(getWinningNumberList(winningNumbers, lottoList));
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumbers, lottoList), purchaseAmount));
    }
}
