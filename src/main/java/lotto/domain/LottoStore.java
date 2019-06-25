package lotto.domain;

import lotto.domain.generator.AutoLottoNumbersGenerator;
import lotto.domain.generator.LottoNumbersGenerator;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoStore {
    private static final LottoNumbersGenerator AUTO_LOTTO_NUMBERS_GENERATOR = new AutoLottoNumbersGenerator();

    public LottoTickets buyLotto(int money) {
        return buyLotto(AUTO_LOTTO_NUMBERS_GENERATOR, money);
    }

    public LottoTickets buyLotto(LottoNumbersGenerator generator, int money) {
        int canBuyLottoCount = money / 1000;

        return new LottoTickets(generator, canBuyLottoCount);
    }
}
