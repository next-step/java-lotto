package lottery;

import java.util.List;

public interface LotteryCalculatorView {
    List<Integer> getNumbersToCompare();
    void showResultTitle();
    void showLotteryCountForNumMatches(List<Integer> lotteryCountForNumMatches);
    void showPnL(PnLResult pnLResult);
}
