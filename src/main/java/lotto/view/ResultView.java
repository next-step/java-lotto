package lotto.view;

import java.util.HashMap;
import java.util.List;

public class ResultView {
    public void printPurchase(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            printNumbers(lottoList.get(i));
        }
    }

    private void printNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }

    public void printStatistics(HashMap<Integer, Integer> agreement, double revenue) {
        System.out.println("당첨 통계");
        System.out.println("-".repeat(9));
        System.out.println("3개 일치 (5000원)-" + agreement.get(5000) + "개");
        System.out.println("4개 일치 (50000원)-" + agreement.get(50000) + "개");
        System.out.println("5개 일치 (1500000원)-" + agreement.get(1500000) + "개");
        System.out.println("6개 일치 (200000000원)-" + agreement.get(2000000000) + "개");
        System.out.println("총 수익률은 " + revenue + "입니다.");
    }
}
