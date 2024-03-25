package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public LottoNumbers(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        this.numbers = new HashSet<>(toInts(splitInput(input)));
    }

    public static LottoNumbers create(LottoNumberStrategy strategy) {
        return new LottoNumbers(strategy.numbers());
    }

    public int matchNumberCount(LottoNumbers winningNums) {
        return (int) winningNums.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(this.numbers);
    }


    private static boolean isBlank(String line) {
        return line == null || line.isBlank();
    }

    private static String[] splitInput(String line) {
        return line.split(",");
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(it -> Integer.parseInt(it.trim()))
                .collect(Collectors.toList());
    }
}
