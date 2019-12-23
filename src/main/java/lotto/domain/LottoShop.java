package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {

    private static final int SALE_PRICE = 1000;
    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    public static LottoBundle order(Order order) {

        List<Lotto> lottos = pickSelfLottoNumberAs(order.getSelfNumbers());

        lottos.addAll(pickAutoLottoNumberWith(getAutoLottoNumberCount(order)));

        return LottoBundle.of(lottos);
    }

    private static List<Lotto> pickAutoLottoNumberWith(int lottoCount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.of(LOTTO_MACHINE.generate()));
        }
        return lottos;
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
