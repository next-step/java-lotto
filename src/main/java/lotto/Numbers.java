package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private final Set<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public static Numbers toNumbers(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        return new Numbers(toInts(splitInput(input)));
    }

    private static String[] splitInput(String line) {
        return line.split(",");
    }

    public static Numbers random() {
        List<Integer> list = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return new Numbers(list.subList(0, 6));
    }

    public int matchNumberCount(Numbers winningNumbers) {
        return (int) winningNumbers.getNumbers().stream()
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
