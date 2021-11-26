package lotto;

import lotto.domain.*;
import lotto.domain.dto.RanksDto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.readMoney();

        LottoShop shop = new LottoShop();
        Lottos lottos = shop.buyLottos(money);
        ResultView.printLottos(lottos);

        String winningNumber = InputView.readWinningNumber();
        int bonusNumber = InputView.readBonusNumber();
        WinLotto winLotto = new WinLotto(new Lotto(winningNumber), LottoNumber.valueOf(bonusNumber));

        Ranks ranks = lottos.checkWinning(winLotto);
        ResultView.printResult(new RanksDto(ranks));
    }

}
