package model;

import view.result.ResultView;

import java.util.Map;

public class MyLottoInfoFacade {
    private Map<Rank, Integer> lotteryStatics;
    private double gross;

    public MyLottoInfoFacade(Map<Rank, Integer> lotteryStatics, double gross) {
        this.lotteryStatics = lotteryStatics;
        this.gross = gross;
    }

    public void view() {
        ResultView.printWinnerMessage(lotteryStatics);
        ResultView.printTotalGross(gross);
    }
}
