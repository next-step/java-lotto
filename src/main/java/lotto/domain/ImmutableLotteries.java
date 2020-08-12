package lotto.domain;

import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import lotto.domain.core.Lotto;
import lotto.domain.core.WinLotto;

import static java.util.stream.Collectors.toList;

final class ImmutableLotteries extends AbstractCollection<Lotto> {
    private final List<Lotto> lottos;

    ImmutableLotteries(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    @Override
    public int size() {
        return lottos.size();
    }

    static ImmutableLotteriesBuilder builder(){
        return new ImmutableLotteriesBuilder();
    }

    List<LottoWinningAndPrizeMoney> compareToEachLottoWithWonLotto(final WinLotto winLotto){
        return stream()
                     .map(winLotto::award)
                     .collect(toList())
            ;
    }
}
