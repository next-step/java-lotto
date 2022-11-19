package lotto;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int autoQuantity = quantity();
        int manualQuantity = manual();

        Lottos buyLotto = new Lottos(new LottoFactory().addLotto(autoQuantity, manualNumber(manualQuantity)));
        printQuantity(autoQuantity, manualQuantity);
        printBuyLottos(buyLotto);

        RankGroup rankGroup = buyLotto.collectRanks(winningLotto());

        Profit profit = new Profit(autoQuantity);
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
