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

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public WinningLottos ranks(LottoWinningNumber lottoWinningNumber) {
        // todo stream 으로 해결할 방법을 찾아보자.
        WinningLottos winningLottos = new WinningLottos();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.rank(lottoWinningNumber);
            winningLottos.addToRank(lottoRank, lotto);
        }

        return winningLottos;
    }

    @Override public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
