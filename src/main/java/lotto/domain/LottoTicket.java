package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNotDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE)
            throw new IllegalArgumentException("number size should be 6.");
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size())
            throw new IllegalArgumentException("number should not be duplicate.");
    }

    public LottoRank rank(LottoTicket winningTicket) {
        long count = numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();

        return LottoRank.of((int) count);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
