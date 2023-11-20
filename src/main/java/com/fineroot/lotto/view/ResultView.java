package com.fineroot.lotto.view;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.viewmodel.ResultViewModel;

public class ResultView {
    private ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel){
        this.resultViewModel = resultViewModel;
    }

    public void drawTotalLottoCount(){
        System.out.println(Integer.toString(resultViewModel.getLottoCount()).concat("개를 구매했습니다."));
    }

    public void drawLotteryBundleStatus(){
        LottoBundleStatus lotteryBundleStatus = resultViewModel.getLotteryBundleStatus();
        for (int i = 0; i < lotteryBundleStatus.size(); i++) {
            System.out.println("[".concat(lotteryBundleStatus.get(i)).concat("]").concat(System.lineSeparator()));
        }
    }
}
