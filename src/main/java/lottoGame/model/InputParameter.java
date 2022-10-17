package lottoGame.model;

public class InputParameter {
    private static final int ticketPrice = 1000;
    private final int lotteryNum;
    private final int amount;


    public InputParameter(int amount) {
        this.amount = amount;
        this.lotteryNum = amount / ticketPrice;
    }

    public int getLotteryNum() {
        return lotteryNum;
    }

    public int getAmount() {
        return amount;
    }
}
