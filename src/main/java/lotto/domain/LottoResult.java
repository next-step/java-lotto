package lotto.domain;

import lotto.enums.LottoWinnerPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final List<Integer> result;
    private int priceTotal;
    private final double returnRate;

    public int getPriceTotal() {
        return priceTotal;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public LottoResult(List<Integer> result, int buyPrice) {
        this.result = result;
        for (Integer matchedNumber : result) {
            priceTotal += LottoWinnerPrice.getPrice(matchedNumber);
        }
        returnRate = Math.round((double) priceTotal / buyPrice * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) object;
        return priceTotal == that.priceTotal && Objects.equals(result, that.result);
    }

    public int getWinnerCount(int matchedNumber) {
        return (int) result.stream()
                .filter(s -> s == matchedNumber)
                .count();
    }

    public static LottoResult getLottoResult(List<Lotto> lottos, Lotto winner, int lottoPrice) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(lotto.compareTo(winner));
        }
        Collections.sort(result);
        return new LottoResult(result, lottos.size() * lottoPrice);
    }

}
