package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> ticket;

    public LottoTicket() {
        this.ticket = autoNumberGenerate();
    }

    public List<Integer> showTicketNumber() {
        return ticket;
    }

    public int findMatchCount(LottoWinningTicket lottoWinningTicket) {
        List<Integer> copyList = new ArrayList<>(lottoWinningTicket.getWinningNumber());
        copyList.removeAll(ticket);
        return LottoTicketUtils.RANGE - copyList.size();
    }

    private List<Integer> autoNumberGenerate() {
        List<Integer> lotto = new ArrayList<>();

        Collections.shuffle(LottoTicketUtils.lottoNumberRange);
        List<Integer> randomNumber = LottoTicketUtils.lottoNumberRange.subList(0, LottoTicketUtils.RANGE);

        for (Integer number : randomNumber) {
            lotto.add(number);
        }

        Collections.sort(lotto);
        return lotto;
    }
}
