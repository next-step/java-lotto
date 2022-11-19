package lotto;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        Price price = new Price(buyPrice());
        ManualLotto manualQuantity = new ManualLotto(manual(), price);

        int restQuantity = manualQuantity.rest(price);

        Lottos buyLotto = new Lottos(new LottoFactory().addLotto(restQuantity, manualNumber(manualQuantity)));
        printQuantity(manualQuantity, restQuantity);
        printBuyLottos(buyLotto);

        RankGroup rankGroup = buyLotto.collectRanks(winningLotto());

        Profit profit = new Profit(price.totalQuantity());
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
