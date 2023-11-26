package com.fineroot.lotto.view;

import com.fineroot.lotto.domain.WinningRank;
import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.viewmodel.ResultViewModel;

public class ResultView {

    private final String STATISTIC_VIEW_ROW = "개 일치";

    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
    }

    public void drawEachLotteryCount() {
        System.out.println("수동으로 "
                .concat(resultViewModel.manualLotteryCount())
                .concat("장, 자동으로 ")
                .concat(resultViewModel.autoLotteryCount())
                .concat("개를 구매했습니다."));
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
        if (value != WinningRank.NONE) {
            System.out.print(Integer.toString(value.getMatchCount()).concat(STATISTIC_VIEW_ROW));
            secondOnlyPrint(value);
            System.out.println(" (".concat(Integer.toString(value.getWinnerPrice())
                    .concat("원)- ")
                    .concat(Integer.toString(resultViewModel.matchCount(value)))
                    .concat("개")));
        }
    }

    private void secondOnlyPrint(WinningRank value) {
        if (value == WinningRank.SECOND_PRIZE) {
            System.out.print(", 보너스 볼 일치(");
        }
    }
}
