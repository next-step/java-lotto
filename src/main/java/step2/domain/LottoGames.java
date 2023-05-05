package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private static int DEFAULT_LOTTO_PRICE = 1000;

    public LottoGames() {}

    int howManyBuyGames(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }

    List<LottoGame> buyLottoGame(int gameCount) {
        List<LottoGame> lottoGames = new ArrayList<>(gameCount);
        for (int i = 0; i < gameCount; i++) {
            lottoGames.add(createLottoGame());
        }
        return lottoGames;
    }

    private LottoGame createLottoGame() {
        return new LottoGame(RandomIntegersGenerator.createNumberList());
    }


}
