package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import static lotto.view.InputView.getMoney;
import static lotto.view.InputView.getWinningNumber;
import static lotto.view.ResultView.*;

public class App {

    public static void main(String[] args) {

        Lotto lotto = new Lotto(getMoney());
        printLotto(lotto.getLottoNumbers());

        LottoNumber winningNumber = new LottoNumber(getWinningNumber());
        printWinningInfo(lotto.prize(winningNumber));
    }
}
