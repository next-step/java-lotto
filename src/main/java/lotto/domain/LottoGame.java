package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private static int gameMoney;

    private static List<Integer> gameNumberList;

    public LottoGame(int gameMoney){
        this.gameMoney = gameMoney;
        this.gameNumberList = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }

    public int getGameMoney(){
        return this.gameMoney;
    }

    public String start() {
        LottoTickets lottoTickets = new LottoTickets(gameMoney, gameNumberList);
        return "lotto";
    }
}
