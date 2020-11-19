package step02.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    private final LottoPrice lottoPrice;

    private LottoSeller(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoSeller of(int lottoPrice) {
        return new LottoSeller(LottoPrice.of(lottoPrice));
    }

    public Lottos generateLottos(int payment, LottoGenerator lottoGenerator) {
        int lottoCount = calculateLottoCount(payment);
        List<Lotto> lottos = Stream.iterate(0, n -> n + 1)
                .limit(lottoCount)
                .map(key -> lottoGenerator.generate())
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

    private int calculateLottoCount(int payment) {
        return lottoPrice.calculateLottoCount(payment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoSeller that = (LottoSeller) o;
        return Objects.equals(lottoPrice, that.lottoPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice);
    }

}
