package lotto.domain;

public class LottoGame {

    private static int gameMoney;

    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public LottoGameResults issueLottoTicket() {

        LottoTickets lottoTickets = new LottoTickets(gameMoney);

        LottoGameResults lottoGameResults = new LottoGameResults(lottoTickets);

        return lottoGameResults;
    }
}
