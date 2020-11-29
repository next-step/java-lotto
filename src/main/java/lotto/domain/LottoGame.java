package lotto.domain;

import java.util.List;

public class LottoGame {

    private final int gameMoney;

    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public LottoGameResults issueLottoTicket(List<List<LottoNumber>> manualTickets) {

        LottoTickets lottoTickets = new LottoTickets(gameMoney);
        lottoTickets.issueLottoTicket(manualTickets);

        LottoGameResults lottoGameResults = new LottoGameResults(lottoTickets);

        return lottoGameResults;
    }
}
