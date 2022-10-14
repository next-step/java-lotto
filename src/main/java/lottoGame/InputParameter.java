package lottoGame;

public class InputParameter {
    private static final int TICKETPRICE = 1000;
    private final int lotteryNum;


    public InputParameter(int amount) {
        this.lotteryNum = amount / TICKETPRICE;
    }

    public int getLotteryNum() {
        return lotteryNum;
    }
}
