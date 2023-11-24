package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.domain.WinnerStatus;
import com.fineroot.lotto.domain.WinningRank;
import com.fineroot.lotto.util.LottoUtils;
import java.util.List;

public class ResultViewModel {

    private int lottoCount;
    private LottoBundleStatus lotteryBundleStatus;

    private WinnerStatus winnerStatus;

    public ResultViewModel() {
        this.lottoCount = 0;
        this.lotteryBundleStatus = LottoBundleStatus.from(List.of());
        this.winnerStatus = WinnerStatus.create();
    }

    public void saveLottoCount(final int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void saveLotteryBundleStatus(final LottoBundleStatus lotteryBundleStatus) {
        this.lotteryBundleStatus = lotteryBundleStatus;
    }

    public void saveWinnerStatus(final WinnerStatus winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public LottoBundleStatus getLotteryBundleStatus() {
        return lotteryBundleStatus;
    }

    public int matchCount(WinningRank winningRank) {
        return winnerStatus.matchCount(winningRank);
    }

    public double getTotalEarningRate() {
        return Math.floor(
                winnerStatus.totalEarningRate(LottoPayment.from(lottoCount * LottoUtils.LOTTO_EACH_PRICE)) * 100) /100;
    }
}
