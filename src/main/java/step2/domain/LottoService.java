package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private int lottoCount;
    private List<LottoTicket> lottoTickets;

    public int buyLotto(int price) {
        this.lottoCount = price/1000;
        return lottoCount;
    }

    public List<LottoTicket> generateAutoLotto(int lottoCount) {
        lottoTickets = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }
}
