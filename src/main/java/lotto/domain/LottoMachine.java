package lotto.domain;

import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.HalfManualLottoGenerator;
import lotto.vo.Money;

import java.util.List;

public class LottoMachine {
    public static final Money LOTTO_PRICE = new Money(1_000);

    private LottoMachine() {
    }

    public static LottoBundle buyLottos(Money money) {
        if (LOTTO_PRICE.isLargerThan(money)) {
            throw new IllegalArgumentException("Input money must be more than " + LOTTO_PRICE.getAmount());
        }

        return AutoLottoGenerator.generateLottoBundle(getNumberOfAffordableLottos(money));
    }

    public static LottoBundle buyLottos(List<String> manualLottos, Money money) {
        if (!isMoneyEnough(manualLottos.size(), money)) {
            throw new IllegalArgumentException("You can't buy lottos with this money");
        }

        long numberOfAutoLottos = getNumberOfAutoLottos(manualLottos.size(), money);
        return HalfManualLottoGenerator.generateLottoBundle(manualLottos, numberOfAutoLottos);
    }

    private static boolean isMoneyEnough(long numberOfLottos, Money money) {
        return numberOfLottos <= getNumberOfAffordableLottos(money);
    }

    private static long getNumberOfAffordableLottos(Money money) {
        return money.getAmount() / LOTTO_PRICE.getAmount();
    }

    private static long getNumberOfAutoLottos(long numberOfManualLottos, Money money) {
        long numberOfTotalLottos = getNumberOfAffordableLottos(money);
        return numberOfTotalLottos - numberOfManualLottos;
    }
}
