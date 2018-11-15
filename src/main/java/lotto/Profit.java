package lotto;

import java.util.List;

public class Profit {

    static double profitRate(int totalPrice, int lottoCost) {
        return Double.parseDouble(String.format("%.2f", (totalPrice / (double)lottoCost)));
    }

    static int totalPrice(List<Integer> winResult, List<Integer> winPrice) {
        int total = 0;
        for(int i = 0; i < winResult.size(); i++) {
            total += (winResult.get(i) * winPrice.get(i));
        }

        return total;
    }

}
