package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.dto.LottoBundleStatus;
import java.util.List;

public class ResultViewModel {

    private int lottoCount;
    private LottoBundleStatus lotteryBundleStatus;

    public ResultViewModel() {
        this.lottoCount = 0;
        this.lotteryBundleStatus = LottoBundleStatus.from(List.of());
    }

    public void saveLottoCount(final int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void saveLotteryBundleStatus(final LottoBundleStatus lotteryBundleStatus) {
        this.lotteryBundleStatus = lotteryBundleStatus;
    }

    public int getLottoCount(){
        return lottoCount;
    }

    public LottoBundleStatus getLotteryBundleStatus() {
        return lotteryBundleStatus;
    }
}
