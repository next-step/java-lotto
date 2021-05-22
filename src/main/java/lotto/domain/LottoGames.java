package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoGames implements Iterable<LottoGame>{
    private List<LottoGame> lottoGames = new ArrayList<>();

    public LottoGames(int money) {
        for (int currentMoney = money; currentMoney >= LottoGame.PRICE; currentMoney -= LottoGame.PRICE) {
            lottoGames.add(new LottoGame());
        }
    }

    public LottoGames(int[][] lottoGames) {
        for (int[] lottoGame : lottoGames) {
            this.lottoGames.add(new LottoGame(lottoGame));
        }
    }

    public LottoStatics calculateStatics(LottoGame winGame) {
        LottoStatics statics = new LottoStatics();
        for (LottoGame game : lottoGames) {
            statics.addStatic(winGame.getRank(game));
        }
        return statics;
    }
    public int size() {
        return lottoGames.size();
    }

    @Override
    public Iterator<LottoGame> iterator() {
        return lottoGames.iterator();
    }
}
