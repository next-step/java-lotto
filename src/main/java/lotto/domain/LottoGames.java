package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LottoGames implements Iterable<LottoGame>{
    private List<LottoGame> lottoGames = new ArrayList<>();

    public LottoGames() {
    }

    public LottoGames(int money) {
        while(LottoGame.isAffordable(money)) {
            lottoGames.add(LottoGame.buy(money));
            money -= LottoGame.PRICE;
        }
    }

    public LottoGames(int[][] lottoGames) {
        for (int[] lottoGame : lottoGames) {
            this.lottoGames.add(new LottoGame(lottoGame));
        }
    }

    public int size() {
        return lottoGames.size();
    }

    @Override
    public Iterator<LottoGame> iterator() {
        return lottoGames.iterator();
    }
}
