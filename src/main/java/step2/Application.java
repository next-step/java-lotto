package step2;

import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Money money = InputView.insert();
        List<Lotto> lottos = OutputView.getLotto(money);
        Lotto winLotto = InputView.getWinLotto();

        Statistic.compare(lottos, winLotto);
        OutputView.getResult(money);
    }
}
