package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int NUMBER_LIMIT_COUNT = 6;
    private static final List<Integer> lottoNumberRange = new ArrayList<>();
    static {
        for (int i = 1, end = 45; i <= end; i++) {
            lottoNumberRange.add(i);
        }
    }

    private final Numbers numbers;

    public LottoTicket() {
        Collections.shuffle(lottoNumberRange);
        this.numbers = new Numbers(new ArrayList<>(lottoNumberRange.subList(0, NUMBER_LIMIT_COUNT)));
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Set<Integer> showTicketNumber() {
        return numbers.showNumbers();
    }

    public void bonusNumber(int bonusNumber) {
        numbers.addBonusNumber(bonusNumber);
    }

    public int findMatchCount(LottoTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.showTicketNumber());
        copyList.removeAll(numbers.showNumbers());
        return NUMBER_LIMIT_COUNT - copyList.size();
    }

    public boolean hasBonusNumber(LottoTicket ticket) {
        return numbers.hasBonusNumber(ticket.numbers.getBonusNumber());
    }
}
