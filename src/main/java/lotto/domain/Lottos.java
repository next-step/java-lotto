package lotto.domain;

import lotto.util.LottoGenerate;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<LottoTicket> lottoTickets;

    public Lottos(int gameCount) {
        this.lottoTickets = buyLottoTicket(gameCount);
    }

    private List<LottoTicket> buyLottoTicket(int gameCount) {
        List<LottoTicket> lottoList = new ArrayList<>();

        for(int i = 0; i < gameCount; i ++) {
            lottoList.add(new LottoTicket(LottoGenerate.initLottoNumbers()));
        }

        return lottoList;
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTickets;
    }
}
