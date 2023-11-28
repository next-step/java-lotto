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
        money.buyManualLotto(manualLottoCount);

        List<List<Integer>> inputManualLottoNumbers = InputView.manualLottoNumbers(manualLottoCount);

        int purchaseCount = money.buyAllAutoLotto();
        OutputView.outputPurchaseCount(manualLottoCount, purchaseCount);

        MyLottos myLottos = LottoFactory.buy(purchaseCount);
        myLottos.addManualLottos(
                inputManualLottoNumbers.stream()
                        .map(Lotto::of)
                        .collect(Collectors.toList()));
        OutputView.outputMyLottos(MyLottosResponse.from(myLottos));

        WinningLotto winningLotto = new WinningLotto(InputView.winningNumbers(), InputView.bonusNumber());
        LottoResult lottoResult = myLottos.getLottoResult(winningLotto);

        OutputView.outputLottoStats(LottoStatsResponse.of(lottoResult, money));
    }

}
