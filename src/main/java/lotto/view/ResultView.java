package lotto.view;

import lotto.common.Outer;
import lotto.domain.BuyingLottos;
import lotto.domain.OwnPrize;
import lotto.domain.Prize;
import lotto.domain.WinNumbersCount;

public class ResultView {
    private Outer outer;

    public ResultView(Outer outer) {
        this.outer = outer;
    }
    
    public void printLottos(final BuyingLottos lottos) {
        outer.print(lottos.toString());        
    }
    
    public void printResult(OwnPrize ownPrize) {
        WinNumbersCount winNumbersCount = ownPrize.getWinNumbersCount();
        winNumbersCount.getPrizes().forEach(prize -> 
            outer.print(getMatchesString(prize, winNumbersCount.getMatchedCountAt(prize)))
        );
        outer.print("총 수익률은 " + ownPrize.getEarningsRate().toString() + "입니다.");
    }
    
    private String getMatchesString(Prize prize, int matchedCount) {
        return prize.getInfo() + matchedCount + " 개";
    }
}
