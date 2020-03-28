package lotto;

public class WinningLotto {
    private int amount;
    private int count;

    public WinningLotto(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public void addCount() {
        ++count;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public int getTotalAmount() {
        return amount * count;
    }

}
