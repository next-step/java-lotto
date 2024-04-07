package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers fromIntegers(List<Integer> integers) {
        List<Number> numbers = integers
                                .stream()
                                .map(Number::from)
                                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public static Numbers uniqueRandomOf(int startInclusive, int endInclusive) {
        return fromIntegers(rangeClosed(startInclusive, endInclusive));
    }

    public Numbers createRandomNumbers(int size) {
        return shuffle()
                .subList(size)
                .sortByAsc();
    }

    public int size() {
        return numbers.size();
    }

    public List<Number> toList() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    private Numbers subList(int size) {
        List<Number> numbers = this.numbers.subList(0, size);
        return new Numbers(numbers);
    }

    private Numbers shuffle() {
        Collections.shuffle(numbers);
        return this;
    }

    private Numbers sortByAsc() {
        Collections.sort(numbers);
        return this;
    }

    private static List<Integer> rangeClosed(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive)
                .boxed()
                .collect(Collectors.toList());
    }
}
