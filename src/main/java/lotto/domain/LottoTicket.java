package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int[] possibleNumbers = IntStream.rangeClosed(1, 45).toArray();
    public static final int FIXED_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public LottoTicket() {
        this(generate());
    }

    public LottoTicket(final List<Integer> numbers) {
        validateCountOfNumbers(numbers);

        validateNumberRange(numbers);

        validateDuplicateNumbers(numbers);


        this.numbers = numbers;
    }

    private static List<Integer> generate() {
        List<Integer> shuffledList = Arrays.stream(possibleNumbers).boxed().collect(Collectors.toList());
        Collections.shuffle(shuffledList);

        return shuffledList.subList(0, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateCountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != FIXED_NUMBER_COUNT) {
            throw new IllegalArgumentException(FIXED_NUMBER_COUNT + "개의 숫자를 입력하세요");
        }
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력 불가능합니다");
        }
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || 45 < n)) {
            throw new IllegalArgumentException("1부터 45까지 정수만 입력 가능합니다");
        }
    }

    public int getTheNumberOfCommonNumbers(final LottoTicket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
