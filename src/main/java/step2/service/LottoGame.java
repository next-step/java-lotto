package step2.service;

import step2.domain.*;
import step2.domain.WinningNumber;
import step2.infrastructure.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final int manualLottoCount;

    private LottoGame(int purchaseAmount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public static LottoGame readyGame(int purchaseAmount, int manualLottoCount) {
        return new LottoGame(purchaseAmount, manualLottoCount);
    }

    public List<List<Integer>> generateLotto(List<List<Integer>> manualLottoNumbers) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();
        LottoFactory factory = new LottoFactory(new RandomStrategy());
        List<List<Integer>> autoLottoNumbers = factory.generateLotto(numberOfPurchases());

        generatedLottoNumber.addAll(manualLottoNumbers);
        generatedLottoNumber.addAll(autoLottoNumbers);
        return generatedLottoNumber;
    }

    private int numberOfPurchases() {
        return purchaseAmount / LOTTO_PRICE - manualLottoCount;
    }

    public LottoResult lottoResult(PurchaseNumbers purchaseNumbers, WinningNumber lottoNumber) {
        MatchRecord matchRecord = MatchRecord.createRecord();

        List<Match> matches = purchaseNumbers.countNumber(lottoNumber);
        Map<Match, Integer> numberOfMatches = matchRecord.countMatches(matches);
        float rate = Rate.calculateRate(numberOfMatches, purchaseAmount);

        return LottoResult.makeResult(numberOfMatches, rate);
    }
}
