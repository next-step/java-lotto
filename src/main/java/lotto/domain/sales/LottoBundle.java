package lotto.domain.sales;

import lotto.domain.number.Lotto;
import lotto.domain.prize.WinningPrize;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(int quickPick) {
        this(IntStream.range(0, quickPick)
                .mapToObj(i -> Lotto.create())
                .collect(Collectors.toList()));
    }

    public LottoBundle(String... manuals) {
        this(Stream.of(manuals).map(Lotto::new).collect(Collectors.toList()));
    }

    public LottoBundle(LottoBundle... lottoBundles) {
        this(Arrays.stream(lottoBundles)
                .flatMap(lottoBundle -> lottoBundle.lottos().stream())
                .collect(Collectors.toList()));
    }

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public WinningPrize winningPrize(WinningLotto winningLotto) {
        WinningPrize winningPrize = new WinningPrize();
        for (Lotto lotto : lottos) {
            winningPrize.record(winningLotto.lottoPrize(lotto));
        }
        return winningPrize;
    }

    public Collection<Lotto> lottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
