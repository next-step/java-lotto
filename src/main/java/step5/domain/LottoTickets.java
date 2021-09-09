package step5.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public void buyLottoAutomatically(int num) {
        for (int i = 0; i < num; i++) {
            AutoLottoTicket autoLottoTicket = new AutoLottoTicket();
            lottoTickets.add(autoLottoTicket);
        }

    }

    public void buyLottoManually(ManualLottoTicket manualLottoTicket) {
        lottoTickets.add(manualLottoTicket);
    }
}
