package lotto;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int quantity = quantity();
        printQuantity(quantity);

        Lottos buyLotto = new Lottos(new LottoFactory().addLotto(quantity));
        printBuyLottos(buyLotto);

        RankGroup rankGroup = buyLotto.collectRanks(winningLotto());

        Profit profit = new Profit(quantity);
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
