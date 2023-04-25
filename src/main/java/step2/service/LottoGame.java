package step2.service;

import step2.domain.*;
import step2.domain.Number;
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

    public LottoResult lottoResult(List<List<Integer>> purchaseNumbers, Number lottoNumber) {
        MatchRecord matchRecord = MatchRecord.createRecord();
        Map<Match, Integer> numberOfMatches = matchRecord.countNumber(purchaseNumbers, lottoNumber);
        float rate = Rate.calculateRate(numberOfMatches, purchaseAmount);

        return LottoResult.makeResult(numberOfMatches, rate);
    }
}
