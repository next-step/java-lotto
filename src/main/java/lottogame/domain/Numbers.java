package lottogame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    List<Number> numbers;

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

    public static Numbers ofUniqueRandom(int startInclusive, int endInclusive) {
        return fromIntegers(rangeClosed(startInclusive, endInclusive));
    }

    public List<LottoNumber> toLottoNumber() {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Numbers createRandomNumbers(int size) {
        return shuffle()
                .subList(size)
                .sortByAsc();
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
