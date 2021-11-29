package step2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoPrice {

    private static int LOTTO_PRICE_PER_UNIT = 1000;
    private final String VALID_LOTTO_MINIMUM_AMOUNT_MSG = "로또 구매 최소 금액은 %d 입니다.";
    private List<Integer> rewards = Arrays.asList(0,0,0,5000, 50000, 1500000, 2000000000);
    private int price;

    public LottoPrice(String inputPrice) {
        int price = Integer.parseInt(inputPrice);
        if ( price < LOTTO_PRICE_PER_UNIT) {
            throw new IllegalArgumentException(String.format(VALID_LOTTO_MINIMUM_AMOUNT_MSG, LOTTO_PRICE_PER_UNIT));
        }
        this.price = price;
    }

    public int getAvailableForPurchaseCount() {
        return price / LOTTO_PRICE_PER_UNIT;
    }

    public double calcYield(HashMap<Integer, Integer> map) {
        int totalReward = 0;
        for (Integer key : map.keySet()) {
            totalReward += (map.get(key) * rewards.get(key));
        }
        return (double) totalReward / price;
    }
}
