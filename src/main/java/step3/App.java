package step3;

import step3.domain.Lottos;
import step3.lottoPlace.LastWeekLotto;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Lottos lottos = InputView.buyLotto();
        ResultView.showCurrent(lottos);

        LastWeekLotto lastWeekLotto = InputView.lastWeekLottoNum();
        ResultView.showResult(lastWeekLotto, lottos);
    }
}
