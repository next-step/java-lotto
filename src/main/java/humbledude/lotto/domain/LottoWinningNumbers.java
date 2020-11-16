package humbledude.lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoWinningNumbers {

    private final Set<LottoNumber> winningNumbers;

    public LottoWinningNumbers(Set<LottoNumber> numbers) {
        winningNumbers = numbers;
    }

    public int getMatchedCountWith(LottoTicket ticket) {
        HashSet<LottoNumber> intersection = new HashSet<>(winningNumbers);
        intersection.retainAll(ticket.getNumbers());

        return intersection.size();
    }
}
