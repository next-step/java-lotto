package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {
    private static final int LOTTO_PRICE = 1000;

    private LottoUtil() {}

    public static int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static List<Integer> convertWinningNumber(String input) {
        String[] winNumbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winNumbers) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }
        return winningNumbers;
    }
}
