package lotto.domain;

import java.util.*;
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

    public LottoTicket() {
        this.numbers = generate();
        Collections.sort(numbers);
    }

    private List<LottoNumber> generate() {
        List<LottoNumber> candidates = LottoNumber.getAllNumbers();
        Collections.shuffle(candidates);

        return candidates.subList(0, NUMBERS_SIZE);
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
