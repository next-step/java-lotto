package lottery;

import java.util.List;

public interface LotteryStandView {
    Integer getBuyAmount();
    void showBuyResult(List<Lottery> lotteries);
}
