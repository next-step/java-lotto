package ui;

import lotto.WinningPrice;

import java.util.Map;

public class ResultView {
    public static void printResult(Map<Integer, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("______________");

        for (int equalCount = WinningPrice.getLastEqualCount(); equalCount <= WinningPrice.getFirstEqualCount(); equalCount++) {
            int count = winningResult.get(equalCount);
            System.out.println(equalCount + "개 일치 (" + WinningPrice.of(equalCount).getPrice() + "원)- " + count);
        }
    }
}
