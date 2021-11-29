package lotto.domain;

import java.util.List;

public class LottoBuyMethod {

    public static final int LOTTO_PRICE = 1000;

    private final int buyCountTotal;
    private final List<String> manualNumbers;

    public LottoBuyMethod(int money, List<String> manualNumbers) {
        validate(money, manualNumbers);
        this.buyCountTotal = calculateCountAvailable(money);
        this.manualNumbers = manualNumbers;
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
        return new Lottos(buyCountTotal - manualNumbers.size(), manualNumbers);
    }

    public int getBuyCountTotal() {
        return buyCountTotal;
    }

    public int getManualCount() {
        return manualNumbers.size();
    }

    public int getAutoCount() {
        return buyCountTotal - manualNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoBuyMethod that = (LottoBuyMethod) o;

        if (buyCountTotal != that.buyCountTotal) return false;
        return manualNumbers != null ? manualNumbers.equals(that.manualNumbers) : that.manualNumbers == null;
    }

    @Override
    public int hashCode() {
        int result = buyCountTotal;
        result = 31 * result + (manualNumbers != null ? manualNumbers.hashCode() : 0);
        return result;
    }

}
