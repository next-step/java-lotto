package lotto;

import java.util.*;

public class LottoMachine {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final String ERROR_INVALID_PURCHASE_AMOUNT =
            "금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.";

    public static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<List<Integer>> generateLottos(int money) {
        validateMoney(money);
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < money / PRICE_PER_LOTTO; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static Map<Integer, Integer> calculateResult(List<List<Integer>> lottos, List<Integer> winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (List<Integer> lotto : lottos) {
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

    private static void validateMoney(int money) {
        if (money < PRICE_PER_LOTTO || money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
        }
    }
}
