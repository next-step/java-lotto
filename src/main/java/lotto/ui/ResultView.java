package lotto.ui;

import lotto.application.dto.LottoResponse;
import lotto.domain.WinningAmount;

import java.util.HashMap;

public class ResultView {

    public void showResult(LottoResponse response) {
        System.out.println("당첨 통계");
        HashMap<WinningAmount, Integer> countAllWinning = response.getCountAllWinning();
        for (WinningAmount winningAmount : countAllWinning.keySet()) {
            printWinningResult(countAllWinning, winningAmount);
        }
        printRateOfReturn(response.getRateOfReturn());
    }

    private void printWinningResult(HashMap<WinningAmount, Integer> countAllWinning, WinningAmount winningAmount) {
        int matchCount = winningAmount.getMatchCount();
        int amount = winningAmount.getAmount();
        int count = countAllWinning.get(winningAmount);
        System.out.println(matchCount + "개 일치(" + amount + ")-" + count + "개");
    }

    private void printRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률: " + rateOfReturn);
    }
}
