package lotto.model;

import lotto.dto.OrderRequest;
import lotto.exception.InvalidLottoException;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.LottoMachineValidator.assertMoney;

public class LottoMachine {
    public static final int LOTTO_PER_MONEY = 1_000;

    private LottoMachine() {
    }

    public static LottoPaper purchase(OrderRequest orderRequest) {
        int money = orderRequest.getMoney();

        assertMoney(money);

        int quantity = calculate(money);
        if (quantity == 0) {
            throw new InvalidLottoException("로또를 구매하실 수 없습니다");
        }

        return prepare(quantity);
    }

    private static int calculate(int money) {
        return money / LOTTO_PER_MONEY;
    }

    private static LottoPaper prepare(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumberFactory.selectRandomLottoNumbers()));
        }

        return new LottoPaper(result);
    }

}
