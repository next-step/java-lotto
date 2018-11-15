package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoAmount totalPurchaseAmount;
    private LottoAmount manualPurchaseAmount;
    private List<Attempt> lottoNumbers;

    public LottoGame(int totalPurchaseAmount, int manualPurchaseAmount, NumberGenerator generator) {
        lottoNumbers = new ArrayList<>();
        this.totalPurchaseAmount = new LottoAmount(totalPurchaseAmount);
        this.manualPurchaseAmount = new LottoAmount(manualPurchaseAmount);
        generateByAuto(calculateAutoPurchaseAmount(), generator);
    }

    private void generateByAuto(int amount, NumberGenerator generator) {
        for (int i = 0; i < amount; i++) {
            Attempt attempt = new Attempt(generator);
            this.lottoNumbers.add(attempt);
        }
    }

    public void generateByManual(List<List<LottoNo>> lottoNumbers) {
        List<Attempt> manualAttempts = new ArrayList<>();
        for (List<LottoNo> lottoNumber : lottoNumbers) {
            manualAttempts.add(new Attempt(lottoNumber));
        }
        this.lottoNumbers.addAll(0,manualAttempts);
    }

    public List<Attempt> getLottoNumbers() {
        return lottoNumbers;
    }

    public void calculateAllRank(LottoWinningNo winningNo) {
        for (Attempt attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(winningNo);
        }
    }

    public int calculateAutoPurchaseAmount() {
        return totalPurchaseAmount.getAmount() - manualPurchaseAmount.getAmount();
    }
}
