package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.domain.enums.LottoReward;

public class PurchaseMoney {
    private final int money;
    private final int count;

    public PurchaseMoney(int money) {
        int result = money / Lotto.PRICE;
        validateMoney(money, result);
        this.money = money;
        this.count = result;
    }

    public int getLottoCount() {
        return count;
    }

    private static void validateMoney(int money, int count) {
        if (count * Lotto.PRICE != money) {
            throw new IllegalArgumentException("거스름돈은 반환이 불가능합니다. 로또는 " + Lotto.PRICE + "원 입니다.");
        }
    }

    public float getEarningRate(LottoResult result) {

        int totalPrize = (result.getCount(LottoRank.FIRST) * LottoReward.FIRST.getReward())
                + (result.getCount(LottoRank.SECOND) * LottoReward.SECOND.getReward())
                + (result.getCount(LottoRank.THIRD) * LottoReward.THIRD.getReward())
                + (result.getCount(LottoRank.FOURTH) * LottoReward.FOURTH.getReward());

        return  totalPrize / (float) (this.getLottoCount() * Lotto.PRICE);
    }
}
