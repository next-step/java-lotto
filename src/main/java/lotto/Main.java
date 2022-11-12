package lotto;

import lotto.model.LottoCollection;
import lotto.model.LottoGenerator;
import lotto.model.Profit;
import lotto.model.MatchingCollection;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int quantity = inputQuantity();
        printQuantity(quantity);

        LottoCollection buyLotto = new LottoCollection(new LottoGenerator().addLotto(quantity));
        printLottoNumbers(buyLotto);

        MatchingCollection match = buyLotto.match(inputWinningLotto());

        Profit profit = new Profit(quantity);
        printResult(match, profit.calculate(match));
    }
}
