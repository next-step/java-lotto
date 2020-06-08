package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int buyLottoMoney = InputView.buyLotto();
        Money money = new Money(buyLottoMoney);

        List<Lotto> lottos = LottoMachine.createLottos(money.countLotto());
        ResultView.printLotto(lottos);

        String[] winningNumbers  = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, LottoNumber.valueOf(bonusBall));

        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.matchResult(lottos, winningNumber);
        ResultView.printResult(result, money);
    }
}
