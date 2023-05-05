package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.entity.Lottos;
import step2.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;

public class LottosIssuance {

    private LottosIssuance() {
    }

    public static Lottos issues(Money buyerMoney) {
        var money = buyerMoney.getMoney();
        var price = Lotto.PRICE;

        validateLottoIssuance(money, price);

        List<Lotto> lottos = new ArrayList<>();

        while (canIssueLotto(money)) {
            money -= price;
            lottos.add(issue());
        }

        return new Lottos(lottos);
    }

    private static Lotto issue() {
        return LottoIssuance.issue();
    }

    private static void validateLottoIssuance(int money, int price) {
        if (money < price) {
            final var message = String.format(
                    "구입 금액이 로또 1장 가격보다 작아서 로또를 발급받을 수 없습니다. 구입 금액: %d, 로또 1장 가격: %d",
                    money,
                    price
            );

            throw new IllegalStateException(message);
        }
    }

    private static boolean canIssueLotto(int money) {
        return money >= Lotto.PRICE;
    }

}
