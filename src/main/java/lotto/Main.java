package lotto;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.PurchaseInfomation;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;
import lotto.view.Input;
import lotto.view.Output;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PurchaseInfomation purchaseInfomation = new PurchaseInfomation(Input.inputPurchaseAmount(), Input.inputManualPurchaseCount());

        List<Lotto> manualLottos = Input.inputManualLottoNumber(purchaseInfomation.getManualPurchaseCount());
        Output.printPurchaseCount(purchaseInfomation.getManualPurchaseCount(),
            purchaseInfomation.autoPurchaseCount());

        LottoMachine lottoMachine = new LottoMachine(purchaseInfomation);
        List<Lotto> autoLottos = Lotto.createAutoLottos(lottoMachine.calculateExecuteCount());

        List<Lotto> lottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
            .collect(Collectors.toList());
        Output.printAutoLotto(lottos);

        WinningStatistic winningStatistic = lottoMachine.startLotto(lottos,
            WinningNumbers.fromValues(Input.inputWinningNumbers(),
                LottoNumber.fromInt(Input.inputBonusNumber())));

        Output.printLottoResult(winningStatistic);
    }
}
