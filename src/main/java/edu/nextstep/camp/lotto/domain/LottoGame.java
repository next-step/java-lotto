package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoFactory lottoFactory;
    public static final int LOTTO_BUY_AMOUNT_UNIT = 1_000;

    public LottoGame(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos buyLotto(int amount) {
        validationMoney(amount);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount/LOTTO_BUY_AMOUNT_UNIT; i++) {
            lottos.add(lottoFactory.createLottoNumbers());
        }

        return new Lottos(lottos);
    }

    private void validationMoney(int amount) {
        if (amount < LOTTO_BUY_AMOUNT_UNIT || amount % LOTTO_BUY_AMOUNT_UNIT > 0){
            throw new IllegalArgumentException("구매 금액은 1,000 단위로 입력 하세요.");
        }
    }
}
