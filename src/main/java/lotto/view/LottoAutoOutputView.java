package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;
import lotto.model.WinningResults;

import java.util.List;
import java.util.Map;

public class LottoAutoOutputView {
    public void printLotto(int quantity, List<Lotto> lottos) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResults(Map<WinningResult, Integer> winningResults) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (WinningResult value : WinningResult.values()) {
            if(value == WinningResult.SECOND_PRICE) {
                System.out.println(value.getCountOfWinningNumber() + "개 일치, 보너스 볼 일치(" + value.getWinningAmount() + "원)- " + winningResults.get(value) + "개");
                continue;
            }
            System.out.println(value.getCountOfWinningNumber() + "개 일치(" + value.getWinningAmount() + "원)- " + winningResults.get(value) + "개");
        }
    }

    public void printEarningRate(double earningRate) {
        System.out.print("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.");
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
