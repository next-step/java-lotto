package step3.domain;

import java.util.HashMap;

public class LottosTotalResult extends HashMap<Integer, Integer> {
    public LottosTotalResult() {
        for (int i = 0; i < 7; i++) {
            this.put(i, 0);
        }
    }

    public void plusOne(int numberOfMatched) {
        this.put(numberOfMatched, this.get(numberOfMatched) + 1);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            totalPrice += this.get(lottoResult.numbersToBeMatched) * lottoResult.winningPrice;
        }
        return totalPrice;
    }

    public double getRateOfReturn(int purchasedPrice) {
        return (double) getTotalPrice() / purchasedPrice;
    }
}
