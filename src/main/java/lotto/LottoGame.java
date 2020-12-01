package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;
    public static final int LOTTO_PICK_NUMBERS = 6;

    private final List<Integer> numbers;

    public LottoGame(List<Integer> numbers) {
        validateNumbers(numbers);

        this.numbers = numbers;
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_PICK_NUMBERS) {
            throw new IllegalArgumentException("choose " + LOTTO_PICK_NUMBERS + " numbers");
        }

        if (numbers.stream().anyMatch(n -> !isValidNumber(n))) {
            throw new IllegalArgumentException("invalid number range");
        }

        if (!isUnique(numbers)) {
            throw new IllegalArgumentException("numbers are not unique");
        }
    }

    private static boolean isValidNumber(int n) {
        return LOTTO_NUM_START <= n && n <= LOTTO_NUM_END;
    }

    private static boolean isUnique(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == numbers.size();
    }

    private static <T> List<T> getIntersection(List<T> aList, List<T> bList) {
        HashMap<T, Integer> cardinalityMap = new HashMap<>();

        for (T a : aList) {
            cardinalityMap.put(a, 0);
        }

        for (T b : bList) {
            cardinalityMap.computeIfPresent(b, (k, cardinality) -> cardinality + 1);
        }

        return cardinalityMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public LottoPlace getMatchedPlace(List<Integer> winningNumbers) {
        int matchedSize = getIntersection(winningNumbers, numbers).size();

        return Arrays.stream(LottoPlace.values())
                .filter(lottoPlace -> lottoPlace.getNumMatched() == matchedSize)
                .findFirst()
                .orElse(LottoPlace.MATCHED_NONE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
