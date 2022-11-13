package lotto;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int quantity = quantity();
        printQuantity(quantity);

        LottoCollection buyLotto = new LottoCollection(new LottoFactory().addLotto(quantity));
        printLottoNumbers(buyLotto);

        RankCount rankCount = buyLotto.collectRanks(winningLotto());
        rankCount.putMatchingCount();

        buyLotto.findSecond(rankCount, bonusLotto());

        Profit profit = new Profit(quantity);
        printResult(rankCount, profit.calculate(rankCount));
    }
}
