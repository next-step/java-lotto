package lotto.objects;

import java.util.Map;

public class Profit {
    static double getProfit(Map<Object, Long> result, Money money) {
        Long sum = 0L;

        for (Map.Entry<Object, Long> entry : result.entrySet()) {
            sum += getPrize(entry);
        }

        return (double) Math.round(sum * 100 / money.getMoney()) / 100.0;
    }

    static int getPrize(Map.Entry<Object, Long> entry) {
        int sum = 0;

        for (WinningType winningType : WinningType.values()) {
            if (winningType == entry.getKey()) {
                sum += entry.getValue() * winningType.getWinningAmount();
            }
        }

        return sum;
    }
}
