package lotto.domain;

import java.util.List;

public class LotteryTicket {

    private final Lottery lottery;

    private int price;

    private LotteryTicket(Lottery lottery, int price) {
        this.lottery = lottery;
        this.price = price;
    }

    public LotteryTicket(List<Integer> numberList, int price) {
        this(new Lottery(numberList), price);
    }

    public static LotteryTicket auto(int price) {
        return new LotteryTicket(new Lottery(), price);
    }

    public List<Integer> getLottoNumberList() {
        return lottery.getNumberValueList();
    }

    public int findMatchCount(WinningLotteryTicket winningLotteryTicket) {
        return lottery.getMatchCount(winningLotteryTicket.getLottery());
    }

    public int getPrice() {
        return price;
    }
}
