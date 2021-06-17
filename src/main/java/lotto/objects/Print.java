package lotto.objects;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final public class Print {
    public final String mention;

    public Print(String mention) {
        this.mention = mention;
    }

    public static void printPurchase(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public static void printStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void printResult(WinningType winningType, Map<Object, Long> result) {
        Long counts = 0L;
        for (Map.Entry<Object, Long> entry: result.entrySet()) {
            if (entry.getKey() == winningType) {
                counts = entry.getValue();
            }
        }

        if (winningType != WinningType.LOSE) {
            System.out.println(winningType.getCorrespond() + "- " + counts + "개");
        }
    }

    public static void printYield(Map<Object, Long> result, Money money) {
        double yield = Profit.getProfit(result, money);

        StringBuffer mention = new StringBuffer();
        mention.append("총 수익률은 " + yield + "입니다.");

        if (yield < 1.00) {
            mention.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        System.out.println(mention);
    }

    public void printMention() {
        System.out.println(mention);
    }
}
