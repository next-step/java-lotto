package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final Numbers numbers;

    public LottoTicket() {
        Collections.shuffle(LottoTicketUtils.lottoNumberRange);
        this.numbers = new Numbers(new ArrayList<>(LottoTicketUtils.lottoNumberRange.subList(0, LottoTicketUtils.RANGE)));
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Set<Integer> showTicketNumber() {
        return numbers.showNumbers();
    }

    public void bonusNumber(int bonusNumber){
        numbers.addBonusNumber(bonusNumber);
    }

    public int findMatchCount(LottoTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.showTicketNumber());
        copyList.removeAll(numbers.showNumbers());
        return LottoTicketUtils.RANGE - copyList.size();
    }

    public boolean isBonusNumber() {
        return numbers.hasBonusNumber();
    }
}
