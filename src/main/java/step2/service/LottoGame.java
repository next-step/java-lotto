package step2.service;

import step2.domain.LottoFactory;
import step2.domain.LottoResult;
import step2.domain.MatchRecord;
import step2.domain.Rate;
import step2.infrastructure.RandomStrategy;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoGame readyGame(int purchaseAmount) {
        return new LottoGame(purchaseAmount);
    }

    public List<List<Integer>> generateLotto() {
        LottoFactory factory = new LottoFactory(new RandomStrategy());
        return factory.generateLotto(numberOfPurchases());
    }

    private int numberOfPurchases() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public LottoResult lottoResult(List<List<Integer>> numbers, List<Integer> winningNumbers) {
        MatchRecord matchRecord = MatchRecord.createRecord();
        Map<Integer, Integer> numberOfMatches = matchRecord.countNumber(numbers, winningNumbers);
        float rate = Rate.calculateRate(numberOfMatches, purchaseAmount);

        return LottoResult.makeResult(numberOfMatches, rate);
    }
}
