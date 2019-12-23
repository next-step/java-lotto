package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int SALE_PRICE = 1000;

    public static LottoBundle order(Order order) {

        List<Lotto> lottos = pickSelfLottoNumberAs(order.getSelfNumbers());

        lottos.addAll(pickAutoLottoNumberWith(getAutoLottoNumberCount(order)));

        return LottoBundle.of(lottos);
    }

    private static List<Lotto> pickAutoLottoNumberWith(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.of(LottoMachine.generate()))
                .collect(Collectors.toList());

    }

    private static int getAutoLottoNumberCount(Order order) {
        return order.getPayment() / SALE_PRICE - order.getSelfNumbers().size();
    }

    private static List<Lotto> pickSelfLottoNumberAs(List<String> selfNumbers) {
        return selfNumbers.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());
    }
}
