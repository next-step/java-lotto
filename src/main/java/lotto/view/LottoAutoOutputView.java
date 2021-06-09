package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottoAutoOutputView {
    public void printLotto(int quantity, List<Lotto> lottos) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputWinningResults(List<Integer> numberOfWins) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + numberOfWins.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + numberOfWins.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + numberOfWins.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + numberOfWins.get(3) + "개");
        System.out.println("6개 일치 (2000000000원)- " + numberOfWins.get(4) + "개");
    }

    public void outputEarningRate(float earningRate) {
        System.out.print("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.");
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
