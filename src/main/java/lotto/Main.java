package lotto;

import java.util.List;

import static lotto.InputView.*;
import static lotto.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int lottoQuantity = InputView.inputQuantity();
        InputView.printQuantity(lottoQuantity);

        LottoGenerator generator = new LottoGenerator(lottoQuantity);
        printLottoNumbers(generator.getCollection());

        Winning winning = new Winning(generator.getCollection(),inputWinningNumber());
        List<Integer> winningNumberCount = winning.getWinningNumberCount();

        Profit profit = new Profit(lottoQuantity);
        printResult(winningNumberCount, profit.calculate(winningNumberCount));
    }
}
