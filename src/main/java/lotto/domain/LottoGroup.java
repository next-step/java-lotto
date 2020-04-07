package lotto.domain;

import java.util.*;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public LottoGroup(Lotto... lottos) {
        this.lottos = Arrays.asList(lottos.clone());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Rank> matching(Lotto winningLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(lotto.match(winningLotto));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
