package lotto;

public class LottoInit {
    private final static int DIVISOR = 1000;
    private int cost;
    private int count;


    public LottoInit(int cost) {
        this.cost = cost;
        this.count = cost / DIVISOR;
    }

    public int getCount() {
        return this.count;
    }

    public int getCost() {
        return this.cost;
    }

}
