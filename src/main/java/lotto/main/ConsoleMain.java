package lotto.main;

import lotto.domain.ILottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.dto.LottoMatchResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        long money = InputView.getUserMoney();
        ILottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(money, lottoGenerator);
        lotto.buy();

        ResultView.printUserLotto(lotto);
        List<Integer> winningLotto = InputView.getWinningLotto();
        LottoMatchResult lottoMatchResult = lotto.result(winningLotto);
        ResultView.printLottoMatchResult(lottoMatchResult, money);
    }
}
