package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public static LottoBundle order(Order order) {

        List<Lotto> lottos = pickSelfLottoNumberAs(order.getSelfNumbers());

        lottos.addAll(pickAutoLottoNumberWith(order.getAutoNumberCount()));

        return LottoBundle.of(lottos);
    }

    private static List<Lotto> pickAutoLottoNumberWith(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.of(LottoMachine.generate()))
                .collect(Collectors.toList());
    }

    private static List<Lotto> pickSelfLottoNumberAs(List<String> selfNumbers) {
        return selfNumbers.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());
    }
}
