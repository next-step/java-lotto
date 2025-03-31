package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.TICKET_NUMBER_SIZE;

public class LottoTicket {

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
        if (numbers.size() != TICKET_NUMBER_SIZE)
            throw new IllegalArgumentException("number size should be 6.");
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size())
            throw new IllegalArgumentException("number should not be duplicate.");
    }

    public LottoRank rank(LottoTicket winningTicket, LottoNumber bonusBall) {
        int matchCount = (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();

        int bonusCount = numbers.contains(bonusBall) ? 1 : 0;

        return LottoRank.of(matchCount, bonusCount);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
