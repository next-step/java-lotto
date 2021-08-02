package lotto.domain.money;

import lotto.domain.lotto.Lottos;

import java.util.Objects;

import static lotto.domain.lotto.LottoOffice.LOTTO_PRICE_OF_SINGLE;

public class PaymentInfo {
    private final Money money;
    private final int numberOfManualLottos;

    private PaymentInfo(Money money, Lottos manualLottos) {
        validate(money, manualLottos);
        this.money = money;
        numberOfManualLottos = getManualLottosSize(manualLottos);
    }

    private void validate(Money money, Lottos manualLottos) {
        if (Objects.isNull(money)) {
            throw new IllegalStateException("Money는 null이면 안된다");
        }

        if (money.getAffordableCount(LOTTO_PRICE_OF_SINGLE) < getManualLottosSize(manualLottos)) {
            throw new IllegalStateException("Money는 구매가능한 금액이 있어야한다");
        }
    }

    private int getManualLottosSize(Lottos manualLottos) {
        if (Objects.isNull(manualLottos) || manualLottos.isEmpty()) {
            return 0;
        }

        return manualLottos.size();
    }

    public static PaymentInfo of(Money payment, Lottos manualLottos) {
        return new PaymentInfo(payment, manualLottos);
    }

    public int getAffordableCount(Money baseMoney) {
        return money.getAffordableCount(baseMoney) - numberOfManualLottos;
    }

}
