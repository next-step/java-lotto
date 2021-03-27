package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int START = 1;
    public static final int END = 45;
    public static final int LOTTO_NUMBER = 6;
    private static final List<Integer> range = IntStream.range(START, END + 1)
            .boxed()
            .collect(Collectors.toList());

    private List<Integer> numbers;

    public Lotto() {
        this(creatNumbers());
    }

    private Lotto(List<Integer> numbers) {
        shouldBeSize6(numbers);

        this.numbers = numbers;
    }

    public static Lotto of(String numbersString) {
        if (Objects.isNull(numbersString) || numbersString.isEmpty()) {
            throw new IllegalArgumentException("로또 번호를 입력해주세요!");
        }
        List<Integer> numbers = Arrays.stream(numbersString.split(","))
                .map(String::trim)
                .map(Lotto::parse)
                .peek(Lotto::shouldBeValidNumber)
                .collect(Collectors.toList());
        shouldBeSize6(numbers);
        return new Lotto(numbers);
    }

    private static Integer parse(String numeric) {
        try {
            return Integer.valueOf(numeric);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자값을 입력해주세요.");
        }
    }

    private static void shouldBeValidNumber(Integer number) {
        if (number < START || number > END) {
            throw new IllegalArgumentException("로또 번호는 1~45 범위의 숫자입니다.");
        }
    }

    private static void shouldBeSize6(List numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("중복되지 않은 여섯자리 숫자를 입력하세요.");
        }
    }

    public static List<Integer> creatNumbers() {
        Collections.shuffle(range);
        List<Integer> numbers = new ArrayList<>(range.subList(0, LOTTO_NUMBER));
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchedCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            if (!numbers.get(i).equals(lotto.numbers.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
