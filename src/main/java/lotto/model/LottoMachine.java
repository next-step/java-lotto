package lotto.model;

import lotto.dto.OrderRequest;
import lotto.dto.OrderResponse;
import lotto.exception.InvalidLottoException;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PER_MONEY = 1_000;

    private LottoMachine() {
    }

    public static OrderResponse purchase(OrderRequest orderRequest) {
        int quantity = calculate(orderRequest.getMoney());

        if (quantity == 0) {
            throw new InvalidLottoException("로또를 구매하실 수 없습니다");
        }

        return new OrderResponse(quantity, prepare(quantity));
    }

    private static int calculate(int money) {
        return money / LOTTO_PER_MONEY;
    }

    private static LottoPaper prepare(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumbers.selectRandomLottoNumbers()));
        }

        return new LottoPaper(result);
    }

}
