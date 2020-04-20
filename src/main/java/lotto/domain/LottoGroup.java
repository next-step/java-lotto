package lotto.domain;

import java.util.*;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public LottoGroup(Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Ranks matching(WinningLotto winningLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winningLotto.match(lotto));
        }
        return new Ranks(result);
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
