package study.lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> list;

    public Lottos() {
        this.list = new ArrayList<>();
    }

    public Lottos(List<Lotto> list) {
        this.list = new ArrayList<>(list);
    }

    public Lottos(Lottos list) {
        this(list.list);
    }

    public int size() {
        return list.size();
    }

    protected void addAll(List<Lotto> lottos) {
        this.list.addAll(lottos);
    }

    public Lotto get(int index) {
        return list.get(index);
    }

    public WinningLottos ranks(LottoWinningNumber lottoWinningNumber) {
        Function<Lotto, LottoRank> key =
                lotto -> lotto.rank(lottoWinningNumber);
        Map<LottoRank, List<Lotto>> lottoRanks =
                list.stream().collect(Collectors.groupingBy(key));

        return new WinningLottos(lottoRanks);
    }

    @Override public Iterator<Lotto> iterator() {
        return list.iterator();
    }
}
