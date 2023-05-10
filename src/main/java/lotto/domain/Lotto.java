package lotto.domain;

import lotto.util.LottoUtils;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoTicket> lottoTickets;

    public void buyLottoGames(int gameCount) {
        List<LottoTicket> lottoList = new ArrayList<>();

        for(int i = 0; i < gameCount; i ++) {
            lottoList.add(new LottoTicket(LottoUtils.initLottoNumbers()));
        }


        this.lottoTickets = lottoList;
    }

    public List<LottoTicket> getLottoGames() {
        return this.lottoTickets;
    }
}
