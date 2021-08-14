package step4.domain.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(List<Lotto> one, List<Lotto> two) {
        one.addAll(two);
        this.lottos = new ArrayList<>(one);
    }

    public LottoMatch match(WinOfLotto winOfLotto) {
        LottoMatch lottoMatch = new LottoMatch();

        for (Lotto lotto : lottos) {
            lottoMatch.put(winOfLotto.match(lotto));
        }

        return lottoMatch;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos merge(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
        return new Lottos(lottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
