package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumberGenerator;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOffice {
    public static final int LOWEST_AMOUNT = 1_000;
    private static final Money LOTTO_PRICE_OF_SINGLE = Money.of(LOWEST_AMOUNT);

    public static Lottos purchase(Money money) {
        List<Lotto> lottos = Stream.generate(LottoNumberGenerator::generate)
                .map(LottoNumbers::of)
                .map(Lotto::of)
                .limit(money.getPurchasableQuantity(LOTTO_PRICE_OF_SINGLE))
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

}
