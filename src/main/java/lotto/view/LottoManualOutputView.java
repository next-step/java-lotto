package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;

import java.util.List;

public class LottoManualOutputView {
    public void printLottos(int manualQuantity, int autoQuantity, List<Lotto> lottos) {
        System.out.println();
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 " + autoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputWinningStatistics(float earningRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + WinningResult.getNumberOfFifthPlace() + "개");
        System.out.println("4개 일치 (50000원)- " + WinningResult.getNumberOfFourthPlace() + "개");
        System.out.println("5개 일치 (1500000원)- " + WinningResult.getNumberOfThirdPlace() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + WinningResult.getNumberOfSecondPlace() + "개");
        System.out.println("6개 일치 (2000000000원)- " + WinningResult.getNumberOfFirstPlace() + "개");

        System.out.print("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.");
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
