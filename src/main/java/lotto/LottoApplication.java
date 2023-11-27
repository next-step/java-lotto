package lotto;

import lotto.domain.MatchResult;
import lotto.domain.MyLottos;
import lotto.domain.WinningLotto;
import lotto.util.LottoUtil;
import lotto.view.InputView;

import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int payMoney = InputView.inputPayMoney();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);
        printLottoCount(lottoCount);

        MyLottos myLottos = new MyLottos(lottoCount);
        printMyLottos(myLottos, lottoCount);

        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        printMatchResult(matchResult);

        printReturnRate(matchResult.calculateReturnRate(payMoney));
    }
}
