package lotto.domain;

import java.util.*;

public class LottoTicket {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_SIZE = 6;
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int NUMBER_LOWER_BOUND = 1;
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateNumberNotNull(numbers);
        validateNumberSize(numbers);
        validateNumberBound(numbers);
        validateNotDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public LottoTicket() {
        this.numbers = generate();
    }

    private List<Integer> generate() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < NUMBER_SIZE) {
            uniqueNumbers.add(generateNumber());
        }
        return new ArrayList<>(uniqueNumbers);
    }

    private int generateNumber() {
        return RANDOM.nextInt(NUMBER_UPPER_BOUND - NUMBER_LOWER_BOUND + 1) + NUMBER_LOWER_BOUND;
    }

    private void validateNumberNotNull(List<Integer> numbers) {
        if (numbers.stream().anyMatch(Objects::isNull))
            throw new IllegalArgumentException("number should not be null.");
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE)
            throw new IllegalArgumentException("number size should be 6.");
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size())
            throw new IllegalArgumentException("number should not be duplicate.");
    }

    private void validateNumberBound(List<Integer> numbers) {
        boolean hasOutOfBound = numbers.stream()
                .anyMatch(number -> number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND);

        if (hasOutOfBound)
            throw new IllegalArgumentException(String.format("number should be between %d and %d.", NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND));
    }

    public LottoRank rank(LottoTicket winningTicket) {
        long count = numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();

        return LottoRank.of((int) count);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
