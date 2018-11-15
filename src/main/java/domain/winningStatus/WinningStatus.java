package domain.winningStatus;

import domain.Prize;

public interface WinningStatus {
    void putPrize(Prize prize);

    int getPrizeCount(Prize prize);

    double getProfit();
}
