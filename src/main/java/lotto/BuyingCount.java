package lotto;

public class BuyingCount {
    private int buyingCount;

    public BuyingCount(int num) {
        if (num < 1) {
            throw new RuntimeException("로또는 하나이상 추가해야합니다.");
        }
        this.buyingCount = num;
    }

    public int buyingCount() {
        return this.buyingCount;
    }
}
