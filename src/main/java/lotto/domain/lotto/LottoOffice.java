package lotto.domain.lotto;


import lotto.domain.lotto.number.LottoNumberGenerator;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.money.Money.LOWEST_AMOUNT;

public class LottoOffice {
    private static final Money LOTTO_PRICE_OF_SINGLE = Money.of(LOWEST_AMOUNT);
    private final Money money;

    private LottoOffice(Money money) {
        validate(money);
        this.money = money;
    }

    private void validate(Money money) {
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException("Money 값은 항상 있어야합니다");
        }
    }

    public static LottoOffice of(Money money) {
        return new LottoOffice(money);
    }
    
    public LottoPackage purchase() {
        List<Lotto> lottos = Stream.generate(LottoNumberGenerator::generate)
                .map(LottoNumbers::of)
                .map(Lotto::of)
                .limit(money.getPurchasableQuantity(LOTTO_PRICE_OF_SINGLE))
                .collect(Collectors.toList());

        return LottoPackage.of(Lottos.of(lottos), money);
    }

}
