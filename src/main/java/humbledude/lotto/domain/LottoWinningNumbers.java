package humbledude.lotto.domain;

import java.util.HashSet;
import java.util.Set;

import static humbledude.lotto.domain.LottoTicket.LOTTO_SIZE_OF_NUMBERS;

public class LottoWinningNumbers {

    private final Set<LottoNumber> winningNumbers;

    public LottoWinningNumbers(Set<LottoNumber> numbers) {
        validateNumbers(numbers);
        winningNumbers = numbers;
    }

    public int getMatchedCountWith(LottoTicket ticket) {
        HashSet<LottoNumber> intersection = new HashSet<>(winningNumbers);
        intersection.retainAll(ticket.getNumbers());

        return intersection.size();
    }

    private void validateNumbers(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
    }
}
