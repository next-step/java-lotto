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

        List<Lotto> lottos = LottoMachine.createLottos(InputView.inputManualNumbers(manualLottoCount), money.countLotto());
        ResultView.printLotto(lottos, manualLottoCount);

        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumber(), LottoNumber.valueOf(InputView.inputBonusBall()));

        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.matchResult(lottos, winningNumber);
        ResultView.printResult(result, money);
    }
}
