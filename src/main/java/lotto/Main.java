package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.buyLotto());
        int manualLottoCount = InputView.buyManualLotto(money.countLotto());

        List<Lotto> manualLottos = LottoMachine.createManualLottos(InputView.inputManualNumbers(manualLottoCount));
        List<Lotto> autoLottos = LottoMachine.createAutoLottos(money.countLotto() - manualLottoCount);
        ResultView.printLotto(manualLottos, autoLottos);

        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);

        String[] winningNumbers  = InputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, LottoNumber.valueOf(InputView.inputBonusBall()));

        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.matchResult(lottos, winningNumber);
        ResultView.printResult(result, money);
    }
}
