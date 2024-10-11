package lotto.domain;

import lotto.enums.LottoWinnerPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final List<Integer> result;
    private final double returnRate;

    public double getReturnRate() {
        return returnRate;
    }

    public LottoResult(List<Integer> result, int buyPrice) {
        this.result = result;
        this.returnRate = Math.round((double) getPriceTotal() / buyPrice * 100.0) / 100.0;
    }

    int getPriceTotal() {
        int result = 0;
        for (Integer matchedNumber : this.result) {
            result += LottoWinnerPrice.getPrice(matchedNumber);
        }
        return result;
    }

    public int getWinnerCount(int matchedNumber) {
        return (int) result.stream()
                .filter(count -> count == matchedNumber)
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) object;
        return Double.compare(getReturnRate(), that.getReturnRate()) == 0 && Objects.equals(result, that.result);
    }
}
