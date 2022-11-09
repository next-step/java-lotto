package lotto;

import lotto.model.LottoCollection;
import lotto.model.LottoGenerator;
import lotto.model.Profit;
import lotto.model.WinningNumber;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int quantity = InputView.inputQuantity();
        printQuantity(quantity);

        LottoCollection collection = new LottoCollection(new LottoGenerator().addLotto(quantity));
        printLottoNumbers(collection);

        WinningNumber winningNumber = new WinningNumber(collection,inputWinningNumber());
        List<Integer> winningNumberCount = winningNumber.countWinning();

        Profit profit = new Profit(quantity);
        printResult(winningNumberCount, profit.calculate(winningNumberCount));
    }
}
