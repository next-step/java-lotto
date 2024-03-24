package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public static LottoNumbers toNumbers(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        return new LottoNumbers(toInts(splitInput(input)));
    }

    private static String[] splitInput(String line) {
        return line.split(",");
    }

    public static LottoNumbers random() {
        List<Integer> list = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return new LottoNumbers(list.subList(0, 6));
    }

    public int matchNumberCount(LottoNumbers winningLottoNumbers) {
        return (int) winningLottoNumbers.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private static boolean isBlank(String line) {
        return line == null || line.isBlank();
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(it -> Integer.parseInt(it.trim()))
                .collect(Collectors.toList());
    }
}
