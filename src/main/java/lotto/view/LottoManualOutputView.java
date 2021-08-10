package lotto.view;

import lotto.model.Lotto;
<<<<<<< HEAD

import java.util.List;
=======
import lotto.model.WinningResult;

import java.util.List;
import java.util.Map;
>>>>>>> origin/step2

public class LottoManualOutputView {
    public void printLottos(int manualQuantity, int autoQuantity, List<Lotto> lottos) {
        System.out.println();
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 " + autoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

<<<<<<< HEAD
    public void outputWinningResults(int[] numberOfWins) {
=======
    public void printWinningResults(Map<WinningResult, Integer> winningResults) {
>>>>>>> origin/step2
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

<<<<<<< HEAD
        System.out.println("3개 일치 (5000원)- " + numberOfWins[0] + "개");
        System.out.println("4개 일치 (50000원)- " + numberOfWins[1] + "개");
        System.out.println("5개 일치 (1500000원)- " + numberOfWins[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + numberOfWins[3] + "개");
        System.out.println("6개 일치 (2000000000원)- " + numberOfWins[4] + "개");
    }

    public void outputEarningRate(float earningRate) {
=======
        for (WinningResult value : WinningResult.values()) {
            if (value == WinningResult.SECOND_PRICE) {
                System.out.println(value.getCountOfWinningNumber() + "개 일치, 보너스 볼 일치(" + value.getWinningAmount() + "원)- " + winningResults.get(value) + "개");
                continue;
            }
            System.out.println(value.getCountOfWinningNumber() + "개 일치(" + value.getWinningAmount() + "원)- " + winningResults.get(value) + "개");
        }
    }

    public void printEarningRate(double earningRate) {
>>>>>>> origin/step2
        System.out.print("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.");
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
