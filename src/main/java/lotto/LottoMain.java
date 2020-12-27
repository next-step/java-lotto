package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printMessage("구입금액을 입력해 주세요.");
        long amount = inputView.inputPurchaseAmount();
        LottoCount lottoCount = LotteryMachine.calculateLottoCount(amount);

        outputView.printMessage("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = inputView.inputManualCount();
        LottoCount automaticLottoCount = LotteryMachine.calculateAutomaticLottoCount(lottoCount, manualCount);

        outputView.printMessage("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoList = inputView.inputManualLotto(manualCount);
        List<Lotto> automaticLottoList = LotteryMachine.issueAutomaticLotto(automaticLottoCount);
        List<Lotto> combinedLottoList = Stream.of(manualLottoList, automaticLottoList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Lottos purchaseLottos = new Lottos(combinedLottoList);

        outputView.printLottoCount(manualCount, automaticLottoCount);
        outputView.printLottos(purchaseLottos);

        outputView.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        Lotto luckyLotto = inputView.inputLuckyNumbers();
        outputView.printMessage("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(luckyLotto, bonusNumber);

        LottoStatistic lottoStatistic = purchaseLottos.makeStatistic(winningLotto);
        outputView.printStatistic(lottoStatistic);

        Profit profit = new Profit(lottoStatistic.calculateProfit(amount));
        outputView.printProfit(profit);

    }

}