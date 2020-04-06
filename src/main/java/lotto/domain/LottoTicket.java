package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final Numbers number;
    private int bonusNumber;

    public LottoTicket() {
        Collections.shuffle(LottoTicketUtils.lottoNumberRange);
        this.number = new Numbers(new ArrayList<>(LottoTicketUtils.lottoNumberRange.subList(0, LottoTicketUtils.RANGE)));
    }

    public LottoTicket(List<Integer> numbers) {
        this.number = new Numbers(numbers);
    }

    public Set<Integer> showTicketNumber() {
        return number.showNumbers();
    }

    public int findMatchCount(LottoTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.showTicketNumber());
        copyList.removeAll(number.showNumbers());
        return LottoTicketUtils.RANGE - copyList.size();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return number.showNumbers().contains(bonusNumber);
    }
}
