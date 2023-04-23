package step2.domain;

import step2.infrastructure.RandomStrategy;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private final int purchaseAmount;

    private LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoGame readyGame(int purchaseAmount) {
        return new LottoGame(purchaseAmount);
    }

    public List<List<Integer>> generateNumber() {
        NumberFactory factory = new NumberFactory(new RandomStrategy());
        return factory.createNumber(purchaseAmount);
    }

    public LottoResult countNumber(List<List<Integer>> numbers, List<Integer> winningNumbers) {
        MatchRecord matchRecord = MatchRecord.createRecord();
        Map<Integer, Integer> numberOfMatches = matchRecord.countNumber(numbers, winningNumbers);
        float rate = Rate.calculateRate(numberOfMatches, purchaseAmount);

        return LottoResult.makeResult(numberOfMatches, rate);
    }
}
