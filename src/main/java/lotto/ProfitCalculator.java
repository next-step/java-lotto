package lotto;

import java.util.List;

public class ProfitCalculator {

    public static final int TICKET_PRICE = 1000;

    public static float calculate(List<LottoResult> results) {
        int count = results.size();
        int sum = 0;
        for (LottoResult result : results) {
            sum += result.getPrize();
        }
        return (float) sum / (count * TICKET_PRICE);
    }
}
