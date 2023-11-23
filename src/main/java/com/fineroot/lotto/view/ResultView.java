package com.fineroot.lotto.view;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.domain.WinningRank;
import com.fineroot.lotto.viewmodel.ResultViewModel;

public class ResultView {
    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
    }

    public void drawTotalLottoCount() {
        System.out.println(Integer.toString(resultViewModel.getLottoCount()).concat("개를 구매했습니다."));
    }

    public void drawLotteryBundleStatus() {
        LottoBundleStatus lotteryBundleStatus = resultViewModel.getLotteryBundleStatus();
        for (int i = 0; i < lotteryBundleStatus.size(); i++) {
            System.out.println("[".concat(lotteryBundleStatus.get(i)).concat("]"));
        }
        System.out.println();
    }

    public void drawStatistics() {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (WinningRank value : WinningRank.values()) {
            drawStatusRow(value);
        }
        System.out.println("총 수익률은 "
                .concat(Double.toString((resultViewModel.getTotalEarningRate())))
                .concat("입니다."));
    }

    private void drawStatusRow(WinningRank value) {
        if(value !=WinningRank.NONE){
            System.out.println(Integer.toString(value.getMatchCount()).concat("개 일치 (")
                    .concat(Integer.toString(value.getWinnerPrice())).concat("원)- ")
                    .concat(Integer.toString(resultViewModel.matchCount(value))).concat("개"));
        }
    }
}
