package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.LottoStatsResponse;
import lotto.ui.dto.MyLottosResponse;

import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);

        int manualLottoCount = InputView.manualLottoCount();
        Money balanceMoney = money.buyManualLotto(manualLottoCount);
        int autoLottoCount = balanceMoney.availableBuyLottoCount();

        List<List<Integer>> inputManualLottoNumbers = InputView.manualLottoNumbers(manualLottoCount);
        MyLottos myLottos = LottoFactory.buy(autoLottoCount);
        myLottos.addManualLottos(LottoFactory.buy(inputManualLottoNumbers));

        OutputView.outputPurchaseCount(manualLottoCount, autoLottoCount);
        OutputView.outputMyLottos(MyLottosResponse.from(myLottos));

        WinningLotto winningLotto = new WinningLotto(InputView.winningNumbers(), InputView.bonusNumber());
        LottoResult lottoResult = myLottos.getLottoResult(winningLotto);

        OutputView.outputLottoStats(LottoStatsResponse.of(lottoResult, money));
    }

}
