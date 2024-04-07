package lotto.domain;

public class LottoShop {
    private final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoShop(final int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해주세요.");
        }
        this.money = money;
    }

    public int calculateTotalPurchaseCount(int passiveCount) {
        checkPassivePurchaseCount(passiveCount);
        return this.money / LOTTO_PRICE;
    }

    private void checkPassivePurchaseCount(int passiveCount) {
        if (this.money / LOTTO_PRICE >= passiveCount) {
            return;
        }
        throw new IllegalArgumentException("구매 가능한 로또 수를 초과했습니다.");
    }
}
