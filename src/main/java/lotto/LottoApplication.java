package lotto;

import lotto.data.*;

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
        Lottos manualLottos = getManualLottoNumbers(manualLottoCount);

        LottoBundle lottoBundle = LottoBundle.manualOf(manualLottos);

        viewAmount(autoLottoCount, manualLottoCount);

        lottoBundle.addAuto(getNewLottoList(autoLottoCount));
        viewLottoList(lottoBundle.manual(), lottoBundle.auto());

        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(lottoBundle.auto().getLottos());
        lottoList.addAll(lottoBundle.manual().getLottos());

        Map<LottoWinningPrice, Integer> winningNumberList = getWinningNumberList(winningNumbers, bonusNumber, lottoList);
        viewWinningNumberList(winningNumberList);
        viewRateOfReturn(getRateOfReturn(getAllReturnAmount(winningNumberList), purchaseAmount));
    }
}
