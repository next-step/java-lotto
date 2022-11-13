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

        MatchingCollection collection = new MatchingCollection();
        collection.putMatchingCount(buyLotto.collectRanks(winningLotto()));
        buyLotto.findSecond(collection, bonusLotto());

        Profit profit = new Profit(quantity);
        printResult(collection, profit.calculate(collection));
    }
}
