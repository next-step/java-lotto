package lotto.dto;

import lotto.domain.LottoTicket;

import java.util.List;

public class UserLotto {
    private List<LottoTicket> userLotto;
    private int ticketCount;

    public UserLotto(int ticketCount, List<LottoTicket> userLotto) {
        this.userLotto = userLotto;
        this.ticketCount = ticketCount;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public List<LottoTicket> getUserLotto() {
        return this.userLotto;
    }

}
