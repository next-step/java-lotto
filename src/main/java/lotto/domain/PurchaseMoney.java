package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.Arrays;

public class PurchaseMoney {
    private final int money;
    private final int totalCount;
    private int manualCount;

    public PurchaseMoney(int money) {
        validateMoney(money);
        this.money = money;
        this.totalCount = money / Lotto.PRICE;
    }

    public PurchaseMoney(int money, int manualCount) {
        this(money);
        validateManualCount(manualCount);
        this.manualCount = manualCount;
    }

    private void validateManualCount(int manualCount) {
        if (manualCount > this.totalCount) {
            throw new IllegalArgumentException("수동으로 구매할 개수는 전체 갯수보다 클 수 없습니다. 전체 개수: " + totalCount);
        }
    }

    public int getLottoCount() {
        return totalCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    private static void validateMoney(int money) {
        if (money % Lotto.PRICE > 0) {
            throw new IllegalArgumentException("거스름돈은 반환이 불가능합니다. 로또는 " + Lotto.PRICE + "원 입니다.");
        }
    }

    public float getEarningRate(LottoResult result) {
        int totalPrize = Arrays.stream(LottoRank.values())
                .mapToInt(rank -> result.getCount(rank) * rank.getReward()).sum();
        return totalPrize / (float) (this.getLottoCount() * Lotto.PRICE);
    }

    public int getAutoCount() {
        return this.totalCount - this.manualCount;
    }
}
