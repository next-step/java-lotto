package com.java.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    int purchaseAmount = 1000;
    Lotto lotto;

    @BeforeEach
    void setup() {
        this.lotto = new Lotto(purchaseAmount);
    }

    @Test
    @DisplayName("구입금액 만큼 로또 티켓 구매")
    void purchaseLotto() {
        List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        assertThat(lottoTickets.size()).isEqualTo(purchaseAmount / Lotto.LOTTO_PRICE);
    }

}
