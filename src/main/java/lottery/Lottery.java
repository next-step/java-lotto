package lottery;

public class Lottery {
    public static final Integer PRICE = 1000;

    private final LotteryRow row;

    public Lottery(LotteryRow row) {
        this.row = row;
    }

    public LotteryRow getRow() {
        return row;
    }
}
