package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    private List<Lotto> lottoGames = new ArrayList<>();

    public Lottos(int money) {
        int lottoCount = money / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottoGames.add(new Lotto());
        }
    }

    public Lottos(int[][] lottoGames) {
        for (int[] lottoGame : lottoGames) {
            this.lottoGames.add(new Lotto(lottoGame));
        }
    }

    public LottoStatics calculateStatics(Lotto winGame) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto game : lottoGames) {
            ranks.add(winGame.matchCount(game));
        }
        return new LottoStatics(ranks);
    }

    public int size() {
        return lottoGames.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoGames.iterator();
    }
}
