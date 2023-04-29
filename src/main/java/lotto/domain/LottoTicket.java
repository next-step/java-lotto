package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoTicket {
    public static final int LOTTO_TICKET_SIZE = 6;
    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(String.format("로또는 %d개의 번호로 이루어져야 합니다", LOTTO_TICKET_SIZE));
        }
    }

    public boolean containsLottoNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public int matchesLottoNumberCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(number -> number.isMatchesWinningNumber(winningNumbers))
                .count();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(numbers);
    }
}

