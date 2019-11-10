package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LottoResult {
    private final Lotto winningLotto;
    private final List<Lotto> lottos;

    private LottoResult(final Lotto winningLotto, final List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
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

    public double winningRate() {

        return 0;
    }

    public static LottoResultBuilder builder() {
        return new LottoResultBuilder();
    }

    public static final class LottoResultBuilder {
        private Lotto winningLotto;
        private List<Lotto> lottos = new ArrayList<>();

        private LottoResultBuilder() {
        }

        public static LottoResultBuilder aLottoResult() {
            return new LottoResultBuilder();
        }

        public LottoResultBuilder winningLotto(Lotto winningLotto) {
            this.winningLotto = winningLotto;
            return this;
        }

        public LottoResultBuilder addLotto(Lotto lotto) {
            this.lottos.add(lotto);
            return this;
        }

        public LottoResult build() {
            return new LottoResult(winningLotto, lottos);
        }
    }
}
