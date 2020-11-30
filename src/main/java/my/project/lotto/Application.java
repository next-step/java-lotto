package my.project.lotto;

import my.project.lotto.domain.*;
import my.project.lotto.dto.*;
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
        ManualCount manualCount = new ManualCount(InputView.getManualCount());
        ManualLottos manualLottos = new ManualLottos(InputView.getManualNumbers(manualCount));
        Lottos lottos = Lottos.lotto(money, manualLottos);
        ResultView.printLottos(lottos, manualCount);

        List<LottoNumber> winningNumbers = StringUtils.parseToIntList(InputView.getWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        Lotto lastWinningLotto = new Lotto(winningNumbers);
        ResultView.printRanks(new WinningLotto(lottos, lastWinningLotto, bonusNumber));
    }
}
