package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(int number1, int number2, int number3, int number4, int number5, int number6) {
        this(Arrays.asList(number1, number2, number3, number4, number5, number6));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> value() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (int number : this.numbers) {
            matchCount += addMatchCount(number, lotto);
        }
        return matchCount;
    }

    private boolean isValid(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private int addMatchCount(int number, Lotto lotto) {
        if (lotto.numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> array = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(array);
        return array.subList(0, 6);
    }
}
