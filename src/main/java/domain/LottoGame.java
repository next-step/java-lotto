package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoAmount totalPurchaseAmount;
    private LottoAmount manualPurchaseAmount;
    private List<Lotto> lottoNumbers;

    public LottoGame(LottoAmount totalPurchaseAmount, LottoAmount manualPurchaseAmount, NumberGenerator generator) {
        lottoNumbers = new ArrayList<>();
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.manualPurchaseAmount = manualPurchaseAmount;
        generateByAuto(calculateAutoPurchaseAmount(), generator);
    }

    private void generateByAuto(LottoAmount amount, NumberGenerator generator) {
        for (int i = 0; i < amount.getAmount(); i++) {
            Lotto attempt = new Lotto(generator);
            this.lottoNumbers.add(attempt);
        }
    }

    public void generateByManual(List<List<LottoNo>> lottoNumbers) {
        List<Lotto> manualAttempts = new ArrayList<>();
        for (List<LottoNo> lottoNumber : lottoNumbers) {
            manualAttempts.add(new Lotto(lottoNumber));
        }
        this.lottoNumbers.addAll(0,manualAttempts);
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public void calculateAllRank(LottoWinningNo winningNo) {
        for (Lotto attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(winningNo);
        }
    }

    public LottoAmount calculateAutoPurchaseAmount() {
        return new LottoAmount(totalPurchaseAmount.getAmount() - manualPurchaseAmount.getAmount());
    }
}
