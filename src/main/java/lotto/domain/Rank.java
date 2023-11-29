package lotto.domain;

public class Rank {
    public int firstCount = 0;
    public int secondCount = 0;
    public int thirdCount = 0;
    public int fourthCount = 0;

    private int totalPrice() {
        return 2000000000 * firstCount + 1500000 * secondCount + 50000 * thirdCount + 5000 * fourthCount;
    }

    public double rateOfReturn(int money) {
        return (double) this.totalPrice() / money * 100;
    }
}
