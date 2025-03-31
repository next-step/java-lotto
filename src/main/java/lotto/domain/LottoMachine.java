package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 돈을 입력받아 로또를 발급하는 기계
 */
public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoTicket buyLotto(Money money) {
        int count = calculateCount(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<LottoNumber> lottoNumbers = LottoNumbers.generate();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return new LottoTicket(lottoList);

    }

    private int calculateCount(Money money) {
        return money.value() / LOTTO_PRICE;
    }
}
