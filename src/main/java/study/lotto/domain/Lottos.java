package study.lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos;

    public static Lottos valueOf(Optional<Lottos> lottos) {
        return lottos.map(Lottos::new).orElseGet(Lottos::new);
    }

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(Lottos lottos) {
        this(lottos.lottos);
    }

    public int size() {
        return lottos.size();
    }

    protected void addAll(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public WinningLottos ranks(LottoWinningNumber lottoWinningNumber) {
        Function<Lotto, LottoRank> key =
                lotto -> lotto.rank(lottoWinningNumber);
        Map<LottoRank, List<Lotto>> lottoRanks =
                lottos.stream().collect(Collectors.groupingBy(key));

        return new WinningLottos(lottoRanks);
    }

    @Override public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
