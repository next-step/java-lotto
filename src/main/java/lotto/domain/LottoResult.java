package lotto.domain;

import lotto.dto.PurchaseMoney;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.floor;
import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class LottoResult {
    private final int INCREMENT_SIZE = 1;

    private Map<Rank, Integer> value = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            value.put(rank, 0);
        }
    }

    public void put(Rank rank) {
        int existingCount = value.get(rank);
        value.put(rank, existingCount + INCREMENT_SIZE);
    }

    public int get(Rank rank) {
        return value.get(rank);
    }

    public long getAllPrize() {
        long result = 0L;
        for (Rank eachRank : Rank.values()) {
            result += (long) eachRank.getPrize() * value.get(eachRank);
        }
        return result;
    }

    public double getProfit(PurchaseMoney purchaseMoney) {
        return (double) getAllPrize() / (floor(purchaseMoney.getAmount() / LOTTO_PRICE) * LOTTO_PRICE);
    }
}
