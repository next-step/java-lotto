package lottoGame.model;

public class InputParameter {
    private static final int ticketPrice = 1000;
    private final int lotteryNum;


    public InputParameter(int amount) {
        this.lotteryNum = amount / ticketPrice;
    }

    public int getLotteryNum() {
        return lotteryNum;
    }
}
