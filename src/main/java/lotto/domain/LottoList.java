package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoList {

    private List<Lotto> lottos;

    public LottoList() {
        this.lottos = new ArrayList<>();
    }

    public LottoList(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException("1 OR MORE");
        }

        lottos = new ArrayList<>(lottosCount);

        for (int i = 0; i < lottosCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    int count(Rank targetRank, WinningLotto winningLotto) {
        int count = 0;

        for (Lotto lotto : lottos) {
            if (winningLotto.determineRank(lotto) == targetRank) {
                count++;
            }
        }

        return count;
    }

    public void forEach(Consumer<Lotto> printConsumer) {
        lottos.forEach(printConsumer);
    }

    public boolean add(Lotto lotto) {
        return lottos.add(lotto);
    }

    @Override
    public String toString() {
        return String.valueOf(lottos);
    }

    private Stream<Lotto> stream() {
        return lottos.stream();
    }

    public static LottoList merge(LottoList a, LottoList b) {
        return new LottoList(Stream.concat(a.stream(), b.stream())
            .collect(Collectors.toList()));
    }
}
