package com.java.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    LottoPurchase lottoPurchase;
    Lotto lotto;

    @BeforeEach
    void setup() {
        this.lottoPurchase = new LottoPurchase(10000, new ArrayList<>());
        this.lotto = new Lotto(lottoPurchase);
    }

    @Test
    @DisplayName("구입금액 만큼 로또 티켓 구매")
    void purchaseLotto() {
        LottoTickets lottoTickets = lotto.getLottoTickets();
        assertThat(lottoTickets.count()).isEqualTo(lottoPurchase.getCountOfLotto());
    }

}
