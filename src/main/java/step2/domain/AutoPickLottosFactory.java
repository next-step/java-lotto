package step2.domain;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoPickLottosFactory implements Function<LottoQuantity, Lottos> {

    @Override
    public Lottos apply(LottoQuantity lottoQuantity) {
        return createLottos(lottoQuantity.getQuantity());
    }

    private Lottos createLottos(final long quantity) {
        return new Lottos(IntStream.range(0, (int) quantity)
                                   .mapToObj(i -> Lotto.create())
                                   .collect(Collectors.toList()));
    }

}
