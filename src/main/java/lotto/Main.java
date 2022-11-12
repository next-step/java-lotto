package lotto;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int quantity = inputQuantity();
        printQuantity(quantity);

        LottoCollection buyLotto = new LottoCollection(new LottoGenerator().addLotto(quantity));
        printLottoNumbers(buyLotto);

        MatchingCollection collection = new MatchingCollection();
        collection.putMatchingCount(buyLotto.collectRanks(inputWinningLotto()));
        buyLotto.findSecond(collection, inputBonusLotto());

        Profit profit = new Profit(quantity);
        printResult(collection, profit.calculate(collection));
    }
}
