package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {
    List<LottoGame> lottoGames = new ArrayList<>();

    public LottoGames() {
    }

    public LottoGames(int money) {
        while(LottoGame.isAffordable(money)) {
            lottoGames.add(LottoGame.buy(money));
            money -= LottoGame.PRICE;
        }
    }

    public int size() {
        return lottoGames.size();
    }
}
