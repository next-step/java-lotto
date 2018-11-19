package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoAmount totalPurchaseAmount;
    private LottoAmount manualPurchaseAmount;
    private List<Lotto> lottoNumbers;

    private LottoGame(LottoAmount totalPurchaseAmount, LottoAmount manualPurchaseAmount, NumberGenerator generator) {
        lottoNumbers = new ArrayList<>();
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.manualPurchaseAmount = manualPurchaseAmount;
        generateByAuto(calculateAutoPurchaseAmount(), generator);
    }

    public static LottoGame from(LottoAmount totalPurchaseAmount, LottoAmount manualPurchaseAmount, NumberGenerator generator){
        return new LottoGame( totalPurchaseAmount, manualPurchaseAmount, generator);
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
            manualAttempts.add(Lotto.from(lottoNumber));
        }
        this.lottoNumbers.addAll(0,manualAttempts);
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public void calculateAllRank(LottoWinning winningNo) {
        System.out.println("lottoNumbers");
        System.out.println(lottoNumbers);
        System.out.println(winningNo);
        System.out.println("winningNo");
        for (Lotto attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(winningNo);
        }
    }

    public LottoAmount calculateAutoPurchaseAmount() {
        return LottoAmount.from(totalPurchaseAmount.getAmount() - manualPurchaseAmount.getAmount());
    }

    @Override
    public String toString() {
        return "LottoGame{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
