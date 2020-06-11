package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.buyLotto());
        int manualLottoCount = InputView.buyManualLotto(money.countLotto());

        List<Lotto> manualLottos = ManualLottoCreator.createLottos(InputView.inputManualNumbers(manualLottoCount));
        List<Lotto> lottos = LottoMachine.createLottos(money.countLotto());
        ResultView.printLotto(lottos);

        String[] winningNumbers  = InputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, LottoNumber.valueOf(InputView.inputBonusBall()));

        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.matchResult(lottos, winningNumber);
        ResultView.printResult(result, money);
    }
}
