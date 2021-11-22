package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {

    private static final String NULL_MONEY_EXCEPTION_MESSAGE = "Money 는 null 값 일 수 없습니다.";
    private static final String LESS_MONEY_EXCEPTION_MESSAGE = "가격보다 Money가 적습니다.";

    private final Money lottoPrice;

    private LottoSeller(Money lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoSeller create(Money lottoPrice) {
        return new LottoSeller(lottoPrice);
    }

    private void validate(Money money) {
        if (money == null) {
            throw new IllegalArgumentException(NULL_MONEY_EXCEPTION_MESSAGE);
        }

        if (money.lessThan(lottoPrice)) {
            throw new IllegalArgumentException(LESS_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public Lottos buyLottos(Money money, LottoGenerator lottoGenerator) {
        validate(money);
        return LongStream.range(0, getNumberToBuy(money))
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::create));
    }

    public Lotto buyLotto(Money money, LottoGenerator lottoGenerator) {
        validate(money);
        return lottoGenerator.generate();
    }

    private long getNumberToBuy(Money money) {
        return money.divide(lottoPrice).longValue();
    }

    public Money getPrice() {
        return lottoPrice;
    }
}
