package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(LottoNumberFactory factory, int money) {
        this.addLottos(factory,money);
    }

    public Lottos(List<List<Integer>> lottos) {
        for( List<Integer> lotto : lottos) {
            this.addCustomLotto(lotto);
        }
    }

    private void addCustomLotto(List<Integer> customNumbers) {
        lottos.add(new Lotto(customNumbers));
    }

    private void addRandomLotto(LottoNumberFactory factory) {
        lottos.add(new Lotto(factory));
    }

    public void addLottos(LottoNumberFactory factory, int money) {
        int lottoCount = money / Lotto.PRICE;

        for (int i = 0; i < lottoCount; i++) {
            this.addRandomLotto(factory);
        }
    }

    public LottoStatics calculateStatics(WinLotto winGame) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto game : lottos) {
            ranks.add(winGame.matchCount(game));
        }
        return new LottoStatics(ranks);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
