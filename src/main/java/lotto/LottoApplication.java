package lotto;

import lotto.data.Lotto;
import lotto.data.LottoCount;
import lotto.data.LottoWinningPrice;
import lotto.data.Lottos;

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
        LottoCount autoLottoCount = LottoCount.of(purchaseAmount);
        LottoCount manualLottoCount = getManualLottoCounts();
        Lottos manualLottoList = getManualLottoNumbers(manualLottoCount);
        viewAmount(autoLottoCount, manualLottoCount);

        List<Lotto> autoLottoList = getNewLottoList(autoLottoCount);
        viewLottoList(manualLottoList, autoLottoList);

        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(autoLottoList);
        lottoList.addAll(manualLottoList.getLottos());

        Map<LottoWinningPrice, Integer> winningNumberList = getWinningNumberList(winningNumbers, bonusNumber, lottoList);
        viewWinningNumberList(winningNumberList);
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumberList), purchaseAmount));
    }
}
