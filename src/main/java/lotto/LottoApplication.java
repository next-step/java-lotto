package lotto;

import lotto.data.Lotto;
import lotto.data.LottoWinningPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.data.Lotto.getNewLottoList;
import static lotto.service.LottoGame.*;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int autoLottoCount = getAmountOfLotto(purchaseAmount);
        int manualLottoCount = getManualLottoCounts();
        List<Lotto> manualLottoList = getManualLottoNumbers(manualLottoCount);
        viewAmount(autoLottoCount, manualLottoCount);

        List<Lotto> autoLottoList = getNewLottoList(autoLottoCount);
        viewLottoList(manualLottoList, autoLottoList);

        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(autoLottoList);
        lottoList.addAll(manualLottoList);

        Map<LottoWinningPrice, Integer> winningNumberList = getWinningNumberList(winningNumbers, bonusNumber, lottoList);
        viewWinningNumberList(winningNumberList);
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumberList), purchaseAmount));
    }
}
