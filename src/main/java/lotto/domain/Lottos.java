package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(LottoNumberFactory factory, int money) {
        this.money = money;
        this.addLottos(factory);
    }

    public Lottos(List<List<Integer>> lottos) {
        for( List<Integer> lotto : lottos) {
            this.addCustomLotto(lotto);
        }
    }

    public Lottos(int money) {
        this.money = money;
    }

    public Lottos(int money, List<List<Integer>> lottos, LottoNumberFactory factory) {
        this.money = money;
        addLottos(lottos);
        addLottos(factory);
    }

    private void addCustomLotto(List<Integer> customNumbers) {
        lottos.add(new Lotto(customNumbers));
    }

    private void addRandomLotto(LottoNumberFactory factory) {
        lottos.add(new Lotto(factory));
    }

    private void addLottos(LottoNumberFactory factory) {
        int lottoCount = money / Lotto.PRICE;

        for (int i = 0; i < lottoCount; i++) {
            this.addRandomLotto(factory);
        }
    }

    private void addLottos(List<List<Integer>> lottoNumbers) {
        int count = Math.min(lottoNumbers.size(), money / Lotto.PRICE);
        for (int i = 0; i < count; i++) {
            this.addCustomLotto(lottoNumbers.get(i));
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
