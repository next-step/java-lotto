package lotto;

public class Lottery {

    public static final int PRICE = 1000;
    private final int count;

    public Lottery(int money) {
        this.count = money / PRICE;
    }
    public int getCount() {
        return count;
    }
}
