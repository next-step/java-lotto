package lotto.domain;

import java.util.*;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_MAX = 45;

    public static int purchase(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        int result = Integer.parseInt(number);
        return result / LOTTO_PRICE;
    }

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        Collections.sort(numbers);

        return numbers.subList(0, LOTTO_COUNT);
    }

    public static int matchCount(List<Integer> winningNumbers, List<Integer> generateNumbers) {
        int result = 0;
        if (winningNumbers.size() != generateNumbers.size()) {
            return 0;
        }

        for (int winningNumber : winningNumbers) {
            if (generateNumbers.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }

    public static List<Integer> parse(String input) {
        List<Integer> result = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            int parsedInt = Integer.parseInt(number.trim());
            validateLottoNumber(parsedInt);
            result.add(parsedInt);
        }
        if (result.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("Invalid number count: " + result.size());
        }
        return result;
    }

    private static void validateLottoNumber(int parsedInt) {
        if (parsedInt < 1 || parsedInt > LOTTO_MAX) {
            throw new IllegalArgumentException("Invalid number: " + parsedInt);
        }
    }

    public static Map<Integer, Integer> calculatePrizeCounts(List<Integer> winningNumbers, List<List<Integer>> tickets) {
        Map<Integer, Integer> prizeCounts = new HashMap<>();
        for (List<Integer> ticket : tickets) {
            int matchCount = matchCount(winningNumbers, ticket);
            if (matchCount >= 3) {
                prizeCounts.put(matchCount, prizeCounts.getOrDefault(matchCount, 0) + 1);
            }
        }
        return prizeCounts;
    }
}
