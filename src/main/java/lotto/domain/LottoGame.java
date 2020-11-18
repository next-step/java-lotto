package lotto.domain;

public class LottoGame {

    private static int gameMoney;

    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public LottoGameResults start() {
        LottoGameResults lottoGameResults = new LottoGameResults(gameMoney);

        LottoTickets lottoTickets = new LottoTickets(gameMoney);

        lottoTickets.getLottoTickets()
                .stream().forEach(lottoTicket -> lottoGameResults.addResult(new LottoGameResult(lottoTicket.getSortedLottoNumbers())));

        return lottoGameResults;
    }
}
