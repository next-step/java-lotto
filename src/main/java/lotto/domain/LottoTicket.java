package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final Numbers number;
    private int bonusNumber;

    public LottoTicket() {
        Collections.shuffle(LottoTicketUtils.lottoNumberRange);
        this.number = new Numbers(LottoTicketUtils.lottoNumberRange.subList(0, LottoTicketUtils.RANGE));
    }

    public LottoTicket(List<Integer> numbers) {
        this.number = new Numbers(numbers);
    }

    public List<Integer> showTicketNumber() {
        return number.getNumber();
    }

    public int findMatchCount(LottoTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.showTicketNumber());
        copyList.removeAll(number.getNumber());
        return LottoTicketUtils.RANGE - copyList.size();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return number.getNumber().contains(bonusNumber);
    }
}
