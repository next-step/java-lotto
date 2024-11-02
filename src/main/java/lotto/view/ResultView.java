package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.WinningPrize;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoAmount(int amount) {
        System.out.println(String.format("총 %d개를 구매하였습니다.", amount));
    }

    public static void printLottoNumbers(List<LottoNumbers> selectedNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumbers lottoNumbers : selectedNumbers) {
            stringBuilder.append(lottoNumbers.getNumbers()).append(System.lineSeparator());
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-".repeat(10));
    }

    public static void printWinningResults(Map<WinningPrize, Integer> winningResults) {
        for (Map.Entry<WinningPrize, Integer> entry : winningResults.entrySet()) {
            printMatchCount(entry.getKey(), entry.getValue());
        }
    }

    public static void printMatchCount(WinningPrize prize, int count) {
        if (prize == WinningPrize.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개%n", prize.getMatchCount(), prize.getPrizeMoney(), count);
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개%n", prize.getMatchCount(), prize.getPrizeMoney(), count);
    }

    public static void printWinningRate(double winningRate) {
        double formattedNumber = Math.floor(winningRate * 100) / 100;
        System.out.println(String.format("총 수익률은 %.2f입니다.", formattedNumber));
    }
}
