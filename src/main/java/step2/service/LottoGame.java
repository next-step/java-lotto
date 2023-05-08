package step2.service;

import step2.domain.*;
import step2.domain.WinningNumber;
import step2.infrastructure.ManualStrategy;
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

    public PurchaseNumbers generateLotto(List<String> manualLottoNumbers) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();
        LottoGenerateStrategy randomStrategy = new RandomStrategy(numberOfPurchases());
        LottoGenerateStrategy manualStrategy = new ManualStrategy(manualLottoNumbers);

        List<List<Integer>> autoNumbers = LottoFactory.generateLotto(randomStrategy);
        List<List<Integer>> manualNumbers = LottoFactory.generateLotto(manualStrategy);

        generatedLottoNumber.addAll(manualNumbers);
        generatedLottoNumber.addAll(autoNumbers);
        return PurchaseNumbers.generate(generatedLottoNumber);
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
