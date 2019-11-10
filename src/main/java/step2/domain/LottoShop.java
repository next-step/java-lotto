package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoShop {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoShop() {
        this(new RandomLottoNumberGenerator());
    }

    public LottoShop(final LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos buy(final long amount, final long price) {
        final long count = amount / price;
        final List<Lotto> lottos = LongStream.range(0, count)
                                              .mapToObj(i -> lottoNumberGenerator.generate())
                                              .map(number -> new Lotto(new LottoPrice(price), number))
                                              .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public Lottos buy(final long amount) {
        return buy(amount, LottoPrice.DEFAULT.price());
    }
}
