package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
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
        List<Integer> numberCandidates = IntStream.rangeClosed(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numberCandidates);

        return numberCandidates.subList(0, NUMBER_SIZE);
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
