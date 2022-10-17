package com.nextstep.lotto.lottoGame;

import com.nextstep.lotto.lottoGame.domain.LottoGame;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoGame lotto = LottoGame.byBudget();
        lotto.result();
    }
}
