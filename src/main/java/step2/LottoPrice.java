package step2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LottoPrice {

    public static final int LOTTO_PRICE_PER_UNIT = 1000;
    public static final String VALID_LOTTO_MINIMUM_AMOUNT_MSG = "로또 구매 최소 금액은 %d 입니다.";
    public static final String VALID_NULL_EMPTY_MSG = "빈 값이 올 수 없습니다.";
    private List<Integer> rewards = Arrays.asList(0,0,0,5000, 50000, 1500000, 2000000000);
    private int price;

    public LottoPrice(String inputPrice) {
        if (inputPrice == null || inputPrice.trim().length() == 0) {
            throw new IllegalArgumentException(VALID_NULL_EMPTY_MSG);
        }
        int price = Integer.parseInt(inputPrice.trim());
        if ( price < LOTTO_PRICE_PER_UNIT) {
            throw new IllegalArgumentException(String.format(VALID_LOTTO_MINIMUM_AMOUNT_MSG, LOTTO_PRICE_PER_UNIT));
        }
        this.price = price;
    }

    public int getAvailableForPurchaseCount() {
        return price / LOTTO_PRICE_PER_UNIT;
    }

    public double calcYield(HashMap<Integer, Integer> matchMap) {
        int totalReward = 0;
        for (Integer key : matchMap.keySet()) {
            totalReward += (matchMap.get(key) * rewards.get(key));
        }
        return (double) totalReward / price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPrice)) return false;
        LottoPrice that = (LottoPrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
