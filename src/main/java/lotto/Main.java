package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int buyLottoMoney = InputView.buyLotto();
        Money money = new Money(buyLottoMoney);

        int lottoCount = money.countLotto();
        Lotto lotto = new Lotto(lottoCount);
        lotto.drawingLotto();

        ResultView.printLottoNumbers(lottoCount, lotto.getLottoNumbers());
    }
}
