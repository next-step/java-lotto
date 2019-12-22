package lotto.domain;

import lotto.common.exception.WrongOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {

    private static final int SALE_PRICE = 1000;
    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    private static List<Lotto> pickAutoLottoNumberWith(int lottoCount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.of(LOTTO_MACHINE.generate()));
        }
        return lottos;
    }

    public static List<Lotto> order(Order order) {

        if (order.getPayment() < SALE_PRICE)
            throw new WrongOrderException(SALE_PRICE + "원 이상만 구매할 수 있습니다.");

        if (order.getSelfNumbers().size() > order.getPayment() / SALE_PRICE)
            throw new WrongOrderException("수동 번호 개수는 금액을 초과할 수 없습니다.");

        List<Lotto> lottos = pickSelfLottoNumberAs(order.getSelfNumbers());

        lottos.addAll(pickAutoLottoNumberWith(getAutoLottoNumberCount(order)));

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
