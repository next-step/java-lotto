package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLottoTickets {
    private List<LottoTicket> userLottoTickets;

    public UserLottoTickets() {
        this.userLottoTickets = new ArrayList<>();
    }

    public void add(LottoTicket lottoTicket) {
        userLottoTickets.add(lottoTicket);
    }

    public List<LottoTicket> getUserLottoTickets() {
        return userLottoTickets;
    }


}
