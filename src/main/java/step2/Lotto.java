package step2;

import java.util.List;
import java.util.Map;

public class Lotto {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();

        NumberGenerateStrategy strategy = new RandomStrategy();
        NumberFactory numberFactory = new NumberFactory(strategy);
        List<List<Integer>> purchaseNumber = numberFactory.createNumber(purchaseAmount);

        PrintView.purchaseNumber(purchaseNumber);

        List<Integer> winningNumber = InputView.winningNumber();

        LottoResult lottoResult = LottoResult.makeResult();
        Map<Integer, Integer> numberOfMatches = lottoResult.countNumber(purchaseNumber, winningNumber);
        float rate = Rate.calculateRate(numberOfMatches, purchaseAmount);

        PrintView.numberOfMatches(numberOfMatches);
        PrintView.winningRate(rate);
    }
}
