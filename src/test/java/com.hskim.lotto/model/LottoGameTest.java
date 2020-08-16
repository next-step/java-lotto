package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoTickets lottoTickets = new LottoTickets(new PurchasePrice("10000"), new FixedNumberMaker());
        LottoWinningTicket winningTicket = new LottoWinningTicket(Arrays.asList(1, 8, 9, 10, 17, 25));
        LottoGame lottoGame = new LottoGame(lottoTickets, winningTicket);

        // when & then
        assertThat(lottoGame).isEqualTo(new LottoGame(lottoTickets, winningTicket));
    }
}
