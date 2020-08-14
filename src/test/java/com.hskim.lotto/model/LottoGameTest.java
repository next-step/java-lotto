package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        NumberMaker numberMaker = new FixedNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice("14000");
        LottoGame lottoGame = new LottoGame(purchasePrice, numberMaker);

        // when & then
        assertThat(lottoGame).isEqualTo(new LottoGame(purchasePrice, numberMaker));
    }
}
