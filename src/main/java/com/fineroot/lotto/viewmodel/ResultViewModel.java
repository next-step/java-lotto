package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.domain.WinnerStatus;
import com.fineroot.lotto.domain.WinningRank;
import com.fineroot.lotto.dto.LotteryOrderSet;
import com.fineroot.lotto.dto.LottoBundleStatus;
import java.util.List;

public class ResultViewModel {

    private LotteryOrderSet lotteryOrderSet;
    private LottoBundleStatus lotteryBundleStatus;
    private WinnerStatus winnerStatus;

    public ResultViewModel() {
        this.lotteryBundleStatus = LottoBundleStatus.from(List.of());
        this.winnerStatus = WinnerStatus.create();
    }

    public void saveLotteryCountSet(final LotteryOrderSet lotteryOrderSet) {
        this.lotteryOrderSet = lotteryOrderSet;
    }

    public void saveLotteryBundleStatus(final LottoBundleStatus lotteryBundleStatus) {
        this.lotteryBundleStatus = lotteryBundleStatus;
    }

    public void saveWinnerStatus(final WinnerStatus winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    public LottoBundleStatus getLotteryBundleStatus() {
        return lotteryBundleStatus;
    }

    public int matchCount(WinningRank winningRank) {
        return winnerStatus.matchCount(winningRank);
    }

    public double getTotalEarningRate() {
        return Math.floor(
                winnerStatus.totalEarningRate(lotteryOrderSet.getLottoPayment()) * 100) / 100;
    }

    public String autoLotteryCount() {
        return lotteryOrderSet.getAutoLotteryCount().toString();
    }

    public String manualLotteryCount() {
        return lotteryOrderSet.getManualLotteryCount().toString();
    }
}
