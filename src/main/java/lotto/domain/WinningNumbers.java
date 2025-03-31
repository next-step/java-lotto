package lotto.domain;

import java.util.Set;

public class WinningNumbers {

    private final Set<Integer> numbers;

    public WinningNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public LottoPrize determineLottoPrize(LottoTicket ticket) {
        int matchCount = ticket.matchCountWith(numbers);
        return LottoPrize.valueOf(matchCount);
    }

    public int size() {
        return numbers.size();
    }
}
