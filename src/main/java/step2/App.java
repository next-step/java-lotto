package step2;

import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Lottos lottos = InputView.buyLotto();
        ResultView.showCurrent(lottos);

        List<Integer> lastWeekLottoNum = InputView.lastWeekLottoNum();
        ResultView.showResult(lastWeekLottoNum, lottos);
    }
}
