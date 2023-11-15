package lotto.ui;

import lotto.application.dto.LottoResponse;
import lotto.domain.WinningAmount;

import java.util.HashMap;

public class ResultView {

    public void showResult(LottoResponse response) {
        System.out.println("당첨 통계");
        System.out.println("3개 일치 (5000원)- 1개");
        HashMap<WinningAmount, Integer> countAllWinning = response.getCountAllWinning();
        for (WinningAmount winningAmount : countAllWinning.keySet()) {
            int matchCount = winningAmount.getMatchCount();
            int amount = winningAmount.getAmount();
            int count = countAllWinning.get(winningAmount);
            System.out.println(matchCount + "개 일치(" + amount + ")-" + count + "개");
        }
    }
}
