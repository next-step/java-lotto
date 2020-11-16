package lotto.domain;

public class LottoGame {

    private static int gameMoney;

    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public String start() {
        LottoTickets lottoTickets = new LottoTickets(gameMoney);
        return "lotto";
    }
}
