package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final String ERROR_INVALID_PURCHASE_AMOUNT =
            "금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.";

    public static List<Lotto> generateLottos(int money) {
        validateMoney(money);
        return LottoGenerator.generateLottos(money / PRICE_PER_LOTTO);
    }

    public static int countMatches(Lotto lotto, Lotto winningNumbers) {
        return lotto.countMatchingNumbers(winningNumbers);
    }

    public static Map<Integer, Integer> calculateResult(List<Lotto> lottos, Lotto winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int match = countMatches(lotto, winningNumbers);
            result.put(match, result.getOrDefault(match, 0) + 1);
        }
        return result;
    }

    public static long calculateTotalPrize(Map<Integer, Integer> result) {
        Map<Integer, Integer> rank = Map.of(
                6, 2_000_000_000,
                5, 1_500_000,
                4, 50_000,
                3, 5_000);
        long totalPrize = 0;
        for (int i = 3; i <= 6; i++) {
            totalPrize += (long) result.getOrDefault(i, 0) * rank.get(i);
        }
        return totalPrize;
    }

    public static double calculateProfitRate(long totalPrize, int money) {
        return (double) totalPrize / money;
    }

    private static void validateMoney(int money) {
        if (money < PRICE_PER_LOTTO || money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
        }
    }

}
