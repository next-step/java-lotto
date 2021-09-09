package step5.domain;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private LottoResult lottoResult = new LottoResult();

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public void match(WinningLottoTicket winningLottoTicket) {
        lottoResult.calculate(lottoTickets, winningLottoTicket);

    }

    public Map<Rank, Integer> lottoResult() {
        return lottoResult.result();
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

    public List<LottoTicket> tickets() {
        return lottoTickets;
    }
}
