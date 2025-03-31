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

    public LottoRank rank(WinningLotto winningLotto) {
        int matchCount = (int) numbers.stream()
                .filter(winningLotto::matchTicket)
                .count();

        boolean hasBonus = numbers.stream()
                .anyMatch(winningLotto::matchBonus);

        return LottoRank.of(matchCount, hasBonus);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public boolean match(LottoNumber number) {
        return numbers.contains(number);
    }
}
