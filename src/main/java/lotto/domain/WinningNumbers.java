package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoPrize determineLottoPrize(LottoTicket ticket) {
        int matchCount = ticket.matchCountWith(numbers);
        return LottoPrize.valueOf(matchCount);
    }
}
