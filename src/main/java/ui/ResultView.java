package ui;

import lotto.WinningPrice;

import java.util.EnumMap;

public class ResultView {
    public static void printResult(EnumMap<WinningPrice, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("______________");

        for (WinningPrice winningPrice : WinningPrice.values()) {
            int count = winningResult.get(winningPrice);
            System.out.println(winningPrice.getEqualCount() + "개 일치 (" + winningPrice.getPrice() + "원)- " + count);
        }

    }

    public static void printRatioOfReturn(Double ratioOfReturn) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", ratioOfReturn));
    }

}
