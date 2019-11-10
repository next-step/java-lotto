package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LottoResult {
    private final Lotto winningLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoResult(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void add(final Lotto lotto) {
        lottos.add(lotto);
    }

    public int count(final LottoMatch lottoMatch) {
        final Function<Lotto, LottoMatch> keyMapper = lotto -> lotto.match(winningLotto);
        final Collector<Object, ?, Long> valueMapper = Collectors.counting();

        final Map<LottoMatch, Long> collect = lottos.stream()
                                                    .collect(Collectors.groupingBy(keyMapper, valueMapper));
        return collect.getOrDefault(lottoMatch, 0L).intValue();
    }

    public double rate() {
        return 0;
    }
}
