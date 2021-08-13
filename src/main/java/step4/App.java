package step4;

import step4.domain.Lottos;
import step4.lottoPlace.LastWeekLotto;
import step4.view.InputView;
import step4.view.ResultView;

public class App {
    public static void main(String[] args) {
        Lottos lottos = InputView.buyLotto();
        ResultView.showCurrent(lottos);

        LastWeekLotto lastWeekLotto = InputView.lastWeekLottoNum();
        ResultView.showResult(lastWeekLotto, lottos);
    }
}
