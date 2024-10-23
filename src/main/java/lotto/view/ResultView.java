package lotto.view;

import lotto.domain.LottoNumbers;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoAmount(int amount) {
        System.out.println(String.format("총 %d개를 구매하였습니다.", amount));
    }

    public static void printLottoNumbers(LottoNumbers selectedNumbers) {
        System.out.println(selectedNumbers.getNumbers());
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-".repeat(10));
    }

    public static void printMatchCount(int prizeCount, int prizeMoney, int matchCount) {
        System.out.println(String.format("%d개 일치 (%d원) - %d개", prizeCount, prizeMoney, matchCount));
    }

    public static void printWinningRate(double winningRate) {
        double formattedNumber = Math.floor(winningRate * 100) / 100;
        System.out.println(String.format("총 수익률은 %.2f입니다.", formattedNumber));
    }
}
