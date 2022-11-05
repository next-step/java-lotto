package lotto;

import lotto.model.LottoCollection;
import lotto.model.LottoGenerator;
import lotto.model.Profit;
import lotto.model.Winning;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int lottoQuantity = InputView.inputQuantity();
        printQuantity(lottoQuantity);

        LottoGenerator generator = new LottoGenerator(lottoQuantity);
        printLottoNumbers(generator.getCollection());

        Winning winning = new Winning(generator.getCollection(),inputWinningNumber());
        List<Integer> winningNumberCount = winning.getWinningNumberCount();

        Profit profit = new Profit(lottoQuantity);
        printResult(winningNumberCount, profit.calculate(winningNumberCount));
    }
}
