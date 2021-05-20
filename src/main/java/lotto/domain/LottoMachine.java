package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    private LottoGames recentGames;

    public LottoMachine() {
        this(new LottoGames());
    }

    public LottoMachine(LottoGames recentGames) {
        this.recentGames = recentGames;
    }

    public LottoGames createLottoGames(int money) {
        recentGames = new LottoGames(money);
        return recentGames;
    }

    public LottoStatics calculateStatics(LottoGame winLottoGame) {
        LottoStatics statics = new LottoStatics();
        for (LottoGame game : recentGames) {
            statics.addStatic(winLottoGame.getRank(game));
        }
        return statics;
    }
}
