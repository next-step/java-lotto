package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.entity.Lottos;
import step2.domain.vo.Money;

import java.util.List;

public class LottosIssuance {

    private LottosIssuance() {
    }

    public static Lottos issues(List<Lotto> lottos, Money buyerMoney) {
        final var money = buyerMoney.getMoney();
        final var purchaseQuantity = (money / Lotto.PRICE) - lottos.size();

        for (int i = 0; i < purchaseQuantity; i++) {
            lottos.add(issue());
        }

        return new Lottos(lottos);
    }

    private static Lotto issue() {
        return LottoIssuance.issue();
    }
}
