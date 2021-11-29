package lotto.domain;

import java.util.List;

public class LottoBuyMethod {

    public static final int LOTTO_PRICE = 1000;

    private final int buyCountTotal;
    private final List<String> manualNumbers;
    private final int autoCount;

    public LottoBuyMethod(int money, List<String> manualNumbers) {
        validate(money, manualNumbers);
        this.buyCountTotal = calculateCountAvailable(money);
        this.manualNumbers = manualNumbers;
        this.autoCount = this.buyCountTotal - this.manualNumbers.size();
    }

    private void validate(int money, List<String> manualNumbers) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 로또를 사실 수 없습니다.");
        }
        if (money < manualNumbers.size() * LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 개수보다 수동으로 더 많이 살 수 없습니다.");
        }
    }

    public int calculateCountAvailable(int money) {
        return money / LOTTO_PRICE;
    }

    public Lottos buy() {
        return new Lottos(autoCount, manualNumbers);
    }

    public int getBuyCountTotal() {
        return buyCountTotal;
    }

    public int getManualCount() {
        return manualNumbers.size();
    }

    public int getAutoCount() {
        return autoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoBuyMethod buyMethod = (LottoBuyMethod) o;

        if (buyCountTotal != buyMethod.buyCountTotal) return false;
        if (autoCount != buyMethod.autoCount) return false;
        return manualNumbers != null ? manualNumbers.equals(buyMethod.manualNumbers) : buyMethod.manualNumbers == null;
    }

    @Override
    public int hashCode() {
        int result = buyCountTotal;
        result = 31 * result + (manualNumbers != null ? manualNumbers.hashCode() : 0);
        result = 31 * result + autoCount;
        return result;
    }

}
