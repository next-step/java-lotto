package com.java.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
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
    void 구입금액_만큼_로또_티켓_구매() {
        List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        assertThat(lottoTickets.size()).isEqualTo(purchaseAmount / Lotto.LOTTO_PRICE);
    }

}
