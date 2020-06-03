package lotto.util;

import java.util.*;

public class LottoUtil {
    private static final int LOTTO_PRICE = 1000;

    private LottoUtil() {}

    public static int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static List<Integer> convertWinningNumber(String input) {
        String[] winNumbers = input.split(",");
        checkWinNumberValidation(winNumbers);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winNumbers) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }
        return winningNumbers;
    }

    public static void checkWinNumberValidation(String[] winNumbers){
        Set<String> winNumberSet = new HashSet<>(Arrays.asList(winNumbers));
        if (winNumberSet.size() != 6)
            throw new IllegalArgumentException("당첨 번호는 6개가 입력 되어야 합니다.(중복 제외)");
    }
}
