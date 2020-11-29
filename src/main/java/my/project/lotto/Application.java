package my.project.lotto;

import my.project.lotto.domain.*;
import my.project.lotto.view.InputView;
import my.project.lotto.view.ResultView;
import my.project.utils.StringUtils;

/**
 * Created : 2020-11-23 오전 10:52
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Lottos lottos = LottoGame.lotto(money);
        ResultView.printLottos(lottos);

        Lotto lastWinningLotto = new Lotto(StringUtils.parseToIntList(InputView.getWinningNumbers()));
        Ranks ranks = lottos.ranks(lastWinningLotto);
        ResultView.printRanks(ranks);
    }
}
