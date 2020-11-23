package my.project.lotto;

import my.project.lotto.domain.Lotto;
import my.project.lotto.view.InputView;
import my.project.lotto.view.ResultView;

/**
 * Created : 2020-11-23 오전 10:52
 * Developer : Seo
 */
public class LottoApplication {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        Lotto lotto = new Lotto(iv.getMoney());
        //rv.print(lotto.game());
    }
}
