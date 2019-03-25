package lotto.domain;

import lotto.vo.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    public static final Money LOTTO_PRICE = new Money(1_000);
    private static final LottoGenerator lottoGenerator = new AutoLottoGenerator();

    private LottoMachine() {
    }

    public static LottoBundle buyLottos(Money money) {
        if (LOTTO_PRICE.isLargerThan(money)) {
            throw new IllegalArgumentException("Input money must be more than " + LOTTO_PRICE.getAmount());
        }

        return getAutoLottoBundle(getNumberOfAffordableLottos(money));
    }

    public static LottoBundle buyLottos(List<String> manualLottos, Money money) {
        if (!isMoneyEnough(manualLottos.size(), money)) {
            throw new IllegalArgumentException("You can't buy lottos with this money");
        }

        return getTotalLottoBundle(manualLottos, money);
    }

    private static boolean isMoneyEnough(long numberOfLottos, Money money) {
        return numberOfLottos <= getNumberOfAffordableLottos(money);
    }

    private static LottoBundle getTotalLottoBundle(List<String> manualLottos, Money money) {
        LottoBundle manualLottoBundle = getManualLottoBundle(manualLottos);

        long numberOfAutoLottos = getNumberOfAutoLottos(manualLottos.size(), money);
        LottoBundle autoLottoBundle = getAutoLottoBundle(numberOfAutoLottos);

        manualLottoBundle.join(autoLottoBundle);
        return manualLottoBundle;
    }

    private static LottoBundle getManualLottoBundle(List<String> manualLottos) {
        return new LottoBundle(getManualLottos(manualLottos));
    }

    private static List<Lotto> getManualLottos(List<String> manualLottos) {
        return manualLottos.stream()
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::generate)
                .collect(Collectors.toList());
    }

    static LottoBundle getAutoLottoBundle(long numberOfLotto) {
        List<Lotto> lottos = LongStream.range(0, numberOfLotto)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    private static long getNumberOfAffordableLottos(Money money) {
        return money.getAmount() / LOTTO_PRICE.getAmount();
    }

    private static long getNumberOfAutoLottos(long numberOfManualLottos, Money money) {
        long numberOfTotalLottos = getNumberOfAffordableLottos(money);
        return numberOfTotalLottos - numberOfManualLottos;
    }
}
