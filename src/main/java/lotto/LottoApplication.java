package lotto;

import java.util.EnumMap;

public class LottoApplication {
    public static final int EACH_PRICE = 1000;

    public static void main(String[] args) {
        int totalCost = InputView.totalCost();
        int quantity = totalCost / EACH_PRICE;

        InputView.quantity(quantity);
        LottoMachine lottoMachine = new LottoMachine(quantity);

        InputView.print(lottoMachine.lottos());

        LottoNumbers winningNumbers = InputView.winningNumbers();
        EnumMap<MatchedNumbers, Long> result = lottoMachine.result(winningNumbers);
        float profit = lottoMachine.profit(totalCost);

        InputView.summary(result);
        InputView.profit(profit);
    }
}
