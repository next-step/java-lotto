package my.project.lotto;

import my.project.lotto.domain.*;
import my.project.lotto.view.InputView;
import my.project.lotto.view.ResultView;
import my.project.utils.StringUtils;

import java.util.List;

/**
 * Created : 2020-11-23 오전 10:52
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Lottos lottos = Lottos.lotto(money);
        ResultView.printLottos(lottos);

        List<LottoNumber> winningNumbers = StringUtils.parseToIntList(InputView.getWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        Lotto lastWinningLotto = new Lotto(winningNumbers);
        Ranks ranks = lottos.ranks(lastWinningLotto, bonusNumber);
        ResultView.printRanks(ranks);
    }
}
