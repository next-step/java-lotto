package step4.domain.lotto;

import step4.domain.money.Cache;
import step4.domain.money.Money;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final Integer LOTTO_PRICE = 1000;

    public static Lotto randomLotto(Money money) {
        return sell(money, new RandomStrategy());
    }

    public static List<Lotto> randomLottoBulk(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.amount() / LOTTO_PRICE; i++) {
            lottos.add(randomLotto(money));
        }

        return lottos;
    }

    public static Lotto manualLotto(Money money, List<LottoNumber> lottoNumbers) {
        return sell(money, () -> lottoNumbers);
    }

    private static Lotto sell(Money money, LottoStrategy lottoStrategy) {
        money.minus(new Cache(1000));
        return Lotto.create(lottoStrategy.createNumbers());
    }

}
