package lotto.domain;

import lotto.vo.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    public static final Money LOTTO_PRICE = new Money(1_000);

    private LottoMachine() {
    }

    public static LottoBundle buyLottos(Money money) {
        if (LOTTO_PRICE.isLargerThan(money)) {
            throw new IllegalArgumentException("Input money must be more than " + LOTTO_PRICE.getAmount());
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    public static LottoBundle buyLottos(LottoBundle manualLottoBundle, Money money) {
        if (!isMoneyEnough(manualLottoBundle, money)) {
            throw new IllegalArgumentException("You can't buy lottos with this money");
        }

        long numberOfAutoLottos = getNumberOfAutoLottos(manualLottoBundle, money);
        LottoBundle autoLottoBundle = getLottos(numberOfAutoLottos);

        manualLottoBundle.join(autoLottoBundle);

        return manualLottoBundle;
    }

    private static boolean isMoneyEnough(LottoBundle lottoBundle, Money money) {
        List<Lotto> lottos = lottoBundle.getLottos();
        return lottos.size() <= getNumberOfAffordableLottos(money);
    }

    static LottoBundle getLottos(long numberOfLotto) {
        List<Lotto> lottos = LongStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    private static long getNumberOfAffordableLottos(Money money) {
        return money.getAmount() / LOTTO_PRICE.getAmount();
    }

    private static long getNumberOfAutoLottos(LottoBundle manualLottoBundle, Money money) {
        long numberOfTotalLottos = getNumberOfAffordableLottos(money);
        List<Lotto> manualLottos = manualLottoBundle.getLottos();

        return numberOfTotalLottos - manualLottos.size();
    }
}
