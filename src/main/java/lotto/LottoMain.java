package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Ranks;
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

        Ranks ranks = lottos.checkWinning(new Lotto(winningNumber));
        ResultView.printResult(new RanksDto(ranks));
    }

}
