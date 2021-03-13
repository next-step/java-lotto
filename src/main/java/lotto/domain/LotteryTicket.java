package lotto.domain;

import java.util.List;

public class LotteryTicket {

    private final Lottery lottery;

    private final int price;

    private LotteryPrize lotteryPrize;

    private LotteryTicket(Lottery lottery, int price) {
        this.lottery = lottery;
        this.price = price;
        this.lotteryPrize = LotteryPrize.UNDEFINED;
    }

    public LotteryTicket(List<Integer> numberList, int price) {
        this(new Lottery(numberList), price);
    }

    public static LotteryTicket auto(int price) {
        return new LotteryTicket(Lottery.auto(), price);
    }

    public List<Integer> getLottoNumberList() {
        return lottery.getNumberValueList();
    }

    public void setLotteryPrize(WinningLotteryTicket winningLotteryTicket) {
        if (lotteryPrize != LotteryPrize.UNDEFINED) {
            throw new IllegalStateException("이미 로또 상금이 정해진 티켓입니다.");
        }
        lotteryPrize = winningLotteryTicket.match(lottery);
    }

    public int getPrice() {
        return price;
    }

    public LotteryPrize getLotteryPrize() {
        return lotteryPrize;
    }
}
