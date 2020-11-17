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

    public Lottos generateLottos(int payment, LottoNumbers lottoNumbers) {
        int lottoCount = lottoPrice.calculateLottoCount(payment);
        List<Lotto> lottos = Stream.iterate(0, n -> n + 1)
                .limit(lottoCount)
                .map(key -> lottoNumbers.generateLotto())
                .collect(Collectors.toList());

        return Lottos.of(lottos);
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
