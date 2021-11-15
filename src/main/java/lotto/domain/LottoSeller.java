package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

import java.math.BigDecimal;

public class LottoSeller {

    private static final String NULL_MONEY_EXCEPTION_MESSAGE = "Money 는 null 값 일 수 없습니다.";
    private static final String LESS_MONEY_EXCEPTION_MESSAGE = "가격보다 Money가 적습니다.";

    private final Money lottoPrice;
    private final LottoGenerator lottoGenerator;

    private LottoSeller(Money lottoPrice, LottoGenerator lottoGenerator) {
        this.lottoPrice = lottoPrice;
        this.lottoGenerator = lottoGenerator;
    }

    public static LottoSeller create(Money lottoPrice, LottoGenerator lottoGenerator) {
        return new LottoSeller(lottoPrice, lottoGenerator);
    }


    public Lottos buyLotto(Money money) {
        validate(money);

        long numberToBuy = money.getNumberToBuy(lottoPrice);
        return lottoGenerator.generateLotto(numberToBuy);
    }

    private void validate(Money money) {
        if (money == null) {
            throw new IllegalArgumentException(NULL_MONEY_EXCEPTION_MESSAGE);
        }

        if (money.lessThan(lottoPrice)) {
            throw new IllegalArgumentException(LESS_MONEY_EXCEPTION_MESSAGE);
        }
    }
}
