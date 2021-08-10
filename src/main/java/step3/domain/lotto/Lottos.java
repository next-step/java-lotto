package step3.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoMatch match(WinOfLotto winOfLotto) {
        LottoMatch lottoMatch = new LottoMatch();

        for (Lotto lotto : lottos) {
            int count = winOfLotto.correctCount(lotto.numbers());
            boolean hasBonusNumber = winOfLotto.hasBonusNumber(lotto);
            lottoMatch.put(LottoRank.find(count, hasBonusNumber));
        }

        return lottoMatch;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
