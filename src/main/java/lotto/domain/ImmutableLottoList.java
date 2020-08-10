package lotto.domain;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

import lotto.domain.core.Lotto;
import lotto.domain.core.WinLotto;

import static java.util.stream.Collectors.toList;

final class ImmutableLottoList extends AbstractList<Lotto> {
    private final List<Lotto> lottos;

    ImmutableLottoList(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    @Override
    public Lotto get(int index) {
        return lottos.get(index);
    }

    @Override
    public int size() {
        return lottos.size();
    }

    static ImmutableLottoListBuilder builder(){
        return new ImmutableLottoListBuilder();
    }

    List<LottoWinningAndPrizeMoney> compareToEachLottoWithWonLotto(final WinLotto winLotto){
        return stream()
                     .map(winLotto::award)
                     .collect(toList())
            ;
    }
}
