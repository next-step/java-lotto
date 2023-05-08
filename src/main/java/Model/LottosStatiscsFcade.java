package model;

import view.result.ResultView;

import java.util.List;

public class LottosStatiscsFcade {
    private List<Lotto> lottos;
    private Lotto winNum;
    private int buyAmount;

    public LottosStatiscsFcade(List<Lotto> lottos, Lotto winNum, int buyAmount) {
        this.lottos = lottos;
        this.winNum = winNum;
        this.buyAmount = buyAmount;
    }

    public void view() {

        WinRule winRule = new WinRule();

        LotteryStatics lotteryStatics = new LotteryStatics(winRule, this.lottos, this.winNum.getLotto());

        Gross gross = new Gross(lotteryStatics.getTotalPrice(), this.buyAmount);

        ResultView.printWinnerMessage(lotteryStatics.getLotteryStatics());
        ResultView.printTotalGross(gross.getGross());
    }
}
