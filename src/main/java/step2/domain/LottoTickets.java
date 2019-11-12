package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(int lottoCount) {
        createLottoTickets(lottoCount);
    }

    private void createLottoTickets(int lottoCount) {
        this.lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public static LottoTickets of(LottoTicket lottoTicket) {
        List<LottoTicket> lotto = new ArrayList<>();
        lotto.add(lottoTicket);

        return new LottoTickets(lotto);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
