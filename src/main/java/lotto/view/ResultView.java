package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printNumbers(lotto.numbers());
        }
    }

    private static void printNumbers(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0;
        for (Integer number : numbers) {
            sb.append(number);
            if (count < numbers.size() - 1) {
                sb.append(",");
            }
            count++;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printResult(Map<Integer, Integer> result) {
        System.out.println("당첨 통계");
        for (Integer key : result.keySet()) {
            System.out.println(key + "개 일치 - " + result.get(key) + "개");
        }
    }
}
