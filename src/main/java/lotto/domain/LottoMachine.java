package lotto.domain;

public class LottoMachine {

    public LottoGames createLottoGames(int money) {
        return new LottoGames(money);
    }

}
