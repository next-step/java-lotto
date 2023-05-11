package lotto.domain;

import lotto.util.LottoGenerate;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<LottoTicket> lottoTickets;

    public Lottos(int gameCount) {
        this.lottoTickets = new ArrayList<>();
        buyLottoTicket(gameCount);
    }

    public Lottos(List<LottoTicket> lottoTickets, int gameCount) {
        this.lottoTickets = lottoTickets;
        buyLottoTicket(gameCount);
    }

    private void buyLottoTicket(int gameCount) {

        for(int i = 0; i < gameCount; i ++) {
            this.lottoTickets.add(new LottoTicket(LottoGenerate.initLottoNumbers()));
        }
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTickets;
    }
}
