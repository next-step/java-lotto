package my.project.lotto;

import my.project.lotto.controller.LottoController;
import my.project.lotto.controller.StatController;
import my.project.lotto.domain.GameRecord;
import my.project.lotto.view.InputView;
import my.project.lotto.view.ResultView;

import java.util.List;

/**
 * Created : 2020-11-23 오전 10:52
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();

        LottoController lctr = new LottoController(iv.getMoney());
        List<GameRecord> records = lctr.lotto();
        rv.printGame(records);

        StatController sctr = new StatController(records, iv.getWinningNumber());
        rv.printStat(sctr.stat());
    }
}
