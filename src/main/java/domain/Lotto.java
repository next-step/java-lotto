package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private int totalPurchaseAmount;
    private int manualPurchaseAmount;
    private List<Attempt> lottoNumbers;

    public Lotto(int totalPurchaseAmount, int manualPurchaseAmount, NumberGenerator generator) {
        lottoNumbers = new ArrayList<>();
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.manualPurchaseAmount = manualPurchaseAmount;
        generateByAuto(calculateAutoPurchaseAmount(), generator);
    }

    private void generateByAuto(int amount, NumberGenerator generator) {
        for (int i = 0; i < amount; i++) {
            Attempt attempt = new Attempt(generator);
            this.lottoNumbers.add(attempt);
        }
    }

    public void generateByManual(List<List<Integer>> lottoNumbers) {
        List<Attempt> manualAttempts = new ArrayList<>();
        for (List<Integer> lottoNumber : lottoNumbers) {
            manualAttempts.add(new Attempt(lottoNumber));
        }
        this.lottoNumbers.addAll(0,manualAttempts);
    }

    public List<Attempt> getLottoNumbers() {
        return lottoNumbers;
    }

    public void calculateAllRank(List<Integer> numbers, int bonusNumber) {
        for (Attempt attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(numbers, bonusNumber);
        }
    }

    public int calculateAutoPurchaseAmount() {
        return this.totalPurchaseAmount - this.manualPurchaseAmount;
    }
}
