package lotto;

import lotto.data.Lotto;
import lotto.data.LottoWinningPrice;

import java.util.List;
import java.util.Map;

import static lotto.service.LottoGame.*;
import static lotto.view.InputView.*;

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
        int bonusNumber = getBonusNumber(winningNumbers);

        Map<LottoWinningPrice, Integer> winningNumberList = getWinningNumberList(winningNumbers, bonusNumber, lottoList);
        viewWinningNumberList(winningNumberList);
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumberList), purchaseAmount));
        viewWinningNumberList(getWinningNumberList(winningNumbers, lottoList));
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumbers, lottoList), purchaseAmount));
    }
}
