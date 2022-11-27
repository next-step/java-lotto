package lotto;

import lotto.model.*;

import static lotto.model.LottoNumber.winningToSet;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        Price price = new Price(buyPrice());
        ManualQuantity manualQuantity = new ManualQuantity(manual(), price);

        LottosFactory lottosFactory = new LottosFactory(manualNumber(manualQuantity));
        int autoQuantity = manualQuantity.restQuantity(price);

        Lottos buyLotto = lottosFactory.allLottos(autoQuantity);
        printQuantity(manualQuantity, autoQuantity);
        printBuyLottos(buyLotto);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningToSet(winningLotto())), LottoNumber.lottoNumber(bonusLotto()));
        RankGroup rankGroup = buyLotto.collectRanks(winningLotto);

        Profit profit = new Profit(price.totalQuantity());
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
