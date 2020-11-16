package humbledude.lotto.domain;

import java.util.HashSet;

public class LottoWinningNumbers {

    private final LottoNumbers winningNumbers;

    public LottoWinningNumbers(LottoNumbers numbers) {
        winningNumbers = numbers;
    }

    public int getMatchedCountWith(LottoTicket ticket) {
        HashSet<LottoNumber> intersection = new HashSet<>(winningNumbers.getNumbers());
        intersection.retainAll(ticket.getLottoNumbers().getNumbers());

        return intersection.size();
    }
}
