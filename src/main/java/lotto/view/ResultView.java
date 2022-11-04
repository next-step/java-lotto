package lotto.view;

import lotto.model.LottoCollection;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoNumbers(LottoCollection collection) {
        for (List<Integer> lotto : collection.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printResult(List<Integer> winningNumberCount, double totalProfit) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치(5000원)- " + winningNumberCount.get(0) + "개");
        System.out.println("4개 일치(50000원)- " + winningNumberCount.get(1) + "개");
        System.out.println("5개 일치(1500000)- " + winningNumberCount.get(2) + "개");
        System.out.println("6개 일치(2000000000)- " + winningNumberCount.get(3) + "개");

        System.out.println("총 수익률은 " + totalProfit + "입니다.");
    }
}
