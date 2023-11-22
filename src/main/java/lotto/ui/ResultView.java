package lotto.ui;

import lotto.application.dto.LottoResponse;
import lotto.domain.WinningAmount;

import java.util.HashMap;

public class ResultView {

    public void showResult(LottoResponse response) {
        System.out.println("당첨 통계");
        HashMap<WinningAmount, Integer> countAllWinning = response.getCountAllWinning();
        for (WinningAmount winningAmount : countAllWinning.keySet()) {
            int matchCount = winningAmount.getMatchCount();
            int amount = winningAmount.getAmount();
            int count = countAllWinning.get(winningAmount);
            printResult(winningAmount, matchCount, amount, count);
        }
        printRateOfReturn(response.getRateOfReturn());
    }

    private void printResult(WinningAmount winningAmount, int matchCount, int amount, int count) {
        if (winningAmount == WinningAmount.FIVE_MATCH_AND_BONUS) {
            hasBonusResult(matchCount, amount, count);
            return;
        }
        System.out.println(matchCount + "개 일치, 보너스 볼 일치(" + amount + ")-" + count + "개");
    }

    private void hasBonusResult(int matchCount, int amount, int count) {
        System.out.println(matchCount + "개 일치, 보너스 볼 일치(" + amount + ")-" + count + "개");
    }

    private void printRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률: " + rateOfReturn);
    }
}
