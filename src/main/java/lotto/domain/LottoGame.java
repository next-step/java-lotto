package lotto.domain;

import java.util.List;

public class LottoGame {

    private static int gameMoney;

    private static List<String> manualTickets;

    public LottoGame(int gameMoney, List<String> manualTickets){
        this.gameMoney = gameMoney;
        this.manualTickets = manualTickets;
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public LottoGameResults issueLottoTicket() {

        LottoTickets lottoTickets = new LottoTickets(gameMoney, manualTickets);

        LottoGameResults lottoGameResults = new LottoGameResults(lottoTickets);

        return lottoGameResults;
    }
}
