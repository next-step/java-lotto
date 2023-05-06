package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoGame> lottoGames;

    public void buyLottoGames(int gameCount) {
        List<LottoGame> lottoList = new ArrayList<>();

        for(int i = 0; i < gameCount; i ++) {
            lottoList.add(new LottoGame());
        }

        this.lottoGames = lottoList;
    }

    public List<LottoGame> getLottoGames() {
        return this.lottoGames;
    }
}
