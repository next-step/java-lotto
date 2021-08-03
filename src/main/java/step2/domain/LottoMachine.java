package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final Integer LOTTO_PRICE = 1000;

    private final LottoStrategy numberStrategy;

    private LottoNumber winOfLotto;

    public LottoMachine(LottoStrategy numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    public List<Lotto> sell(Money money) {
        final int lottoCount = money.amount() / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(new LottoNumber(numberStrategy.createNumbers())));
        }

        return lottos;
    }

    public LottoNumber winOfLotto(List<Integer> winOfNumbers) {
        this.winOfLotto = new LottoNumber(winOfNumbers);
        return winOfLotto;
    }
}
